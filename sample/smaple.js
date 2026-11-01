const express = require('express');
const multer = require('multer');
const csv = require('csv-parser');
const fs = require('fs');
const { pipeline } = require('stream');
const { Pool } = require('pg');

const app = express();

// PostgreSQL connection
const pool = new Pool({
    host: "localhost",
    user: "postgres",
    password: "no-password",
    database: "db-sample",
    port: 5432
});

// Multer with 512MB limit
const upload = multer({
    dest: "uploads/",
    limits: {
        fileSize: 512 * 1024 * 1024 // 512 MB
    },
    fileFilter: (req, file, cb) => {
        if (!file.originalname.endsWith('.csv')) {
            return cb(new Error("Only CSV files are allowed"));
        }
        cb(null, true);
    }
});

const BATCH_SIZE = 100;

// Batch insert
async function insertBatch(rows) {
    if (!rows.length) return;

    const client = await pool.connect();
    try {
        const values = [];
        const placeholders = rows
            .map((row, i) => {
                const idx = i * 3;
                values.push(row.name, row.email, Number(row.age));
                return `($${idx + 1}, $${idx + 2}, $${idx + 3})`;
            })
            .join(",");

        const query = `
            INSERT INTO users (name, email, age)
            VALUES ${placeholders}
        `;

        await client.query(query, values);
    } catch (error) {
        console.error("DB Insert Error:", error.message);
        throw error;
    } finally {
        client.release();
    }
}

// Upload API
app.post("/upload", (req, res) => {
    upload.single("file")(req, res, (err) => {
        if (err instanceof multer.MulterError) {
            if (err.code === "LIMIT_FILE_SIZE") {
                return res.status(413).json({ error: "File size exceeds 512MB limit" });
            }
            return res.status(400).json({ error: err.message });
        }

        if (err) {
            return res.status(400).json({ error: err.message });
        }

        if (!req.file) {
            return res.status(400).json({ error: "CSV file is required" });
        }

        let batch = [];

        pipeline(
            fs.createReadStream(req.file.path),
            csv(),
            async function* (source) {
                for await (const row of source) {
                    batch.push(row);

                    if (batch.length >= BATCH_SIZE) {
                        await insertBatch(batch);
                        batch = [];
                    }
                }

                if (batch.length > 0) {
                    await insertBatch(batch);
                }
            },
            (pipelineErr) => {
                fs.unlinkSync(req.file.path);

                if (pipelineErr) {
                    console.error("Pipeline error:", pipelineErr);
                    return res.status(500).json({ error: "CSV processing failed" });
                }

                res.json({ message: "CSV uploaded & processed successfully" });
            }
        );
    });
});

app.use(express.json({ limit: "500mb" }));

app.listen(3000, () => {
    console.log("Server running on port 3000");
});
