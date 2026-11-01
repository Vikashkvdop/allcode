import dotenv from "dotenv";
dotenv.config();

import mongoose from "mongoose";
import connectDB from "./config/db.js";
import Permission from "./models/Permission.js";
import User from "./models/User.js";
import Record from "./models/Record.js";
import bcrypt from "bcrypt";

const SALT_ROUNDS = parseInt(process.env.BCRYPT_SALT_ROUNDS || "10", 10);

const run = async () => {
  try {
    await connectDB();
    console.log("Seeding...");

    // Clear
    await Permission.deleteMany({});
    await User.deleteMany({});
    await Record.deleteMany({});

    // Permissions mapping
    const perms = [
      { role: "Patient", permissions: ["view_records"] },
      { role: "Nurse", permissions: ["view_records", "update_status"] },
      { role: "Doctor", permissions: ["view_records", "update_status", "prescribe_medication", "request_emergency_access"] },
      { role: "Administrator", permissions: ["manage_users", "view_records", "update_status"] }
    ];
    await Permission.insertMany(perms);
    console.log("Permissions seeded");

    // Users
    const users = [
      { username: "admin", role: "Administrator", password: "AdminPass123!" },
      { username: "dr_smith", role: "Doctor", password: "DoctorPass123!" },
      { username: "nurse_amy", role: "Nurse", password: "NursePass123!" },
      { username: "patient_john", role: "Patient", password: "PatientPass123!" }
    ];

    for (const u of users) {
      const hash = await bcrypt.hash(u.password, SALT_ROUNDS);
      await User.create({ username: u.username, password_hash: hash, role: u.role });
    }
    console.log("Users seeded");

    // Create a record for patient_john
    const patient = await User.findOne({ username: "patient_john" });
    if (patient) {
      await Record.create({
        patient_id: patient._id,
        data: { allergies: ["penicillin"], blood_group: "A+", notes: "Initial intake normal." },
        prescriptions: [],
        status: "active"
      });
      console.log("Patient record created");
    }

    console.log("Seeding completed.");
    process.exit(0);
  } catch (err) {
    console.error(err);
    process.exit(1);
  }
};

run();
