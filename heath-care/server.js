import express from "express";
import dotenv from "dotenv";
import helmet from "helmet";
import cors from "cors";
import morgan from "morgan";
import bodyParser from "body-parser";

import connectDB from "./config/db.js";
import authRoutes from "./routes/authRoutes.js";
import userRoutes from "./routes/userRoutes.js";
import recordRoutes from "./routes/recordRoutes.js";
import rateLimiter from "./middleware/rateLimiter.js";

dotenv.config();
const PORT = process.env.PORT || 4000;

const app = express();

// Security middlewares
app.use(helmet());
app.use(cors());
app.use(morgan("combined"));
app.use(bodyParser.json());
app.use(rateLimiter);

// Connect DB
connectDB();

// Routes
app.use("/auth", authRoutes);
app.use("/users", userRoutes);
app.use("/records", recordRoutes);

// Basic health
app.get("/", (req, res) => res.json({ status: "ok", timestamp: new Date().toISOString() }));

app.use((err, req, res, next) => {
  console.error(err);
  res.status(err.status || 500).json({ error: err.message || "Internal Server Error" });
});

app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
