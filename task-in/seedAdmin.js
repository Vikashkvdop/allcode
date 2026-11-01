require('dotenv').config();
const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const User = require('./models/User');

async function seedAdmin() {
  await mongoose.connect(process.env.MONGO_URI);

  const email = "admin@school.com";
  const exists = await User.findOne({ email });

  if (exists) {
    console.log("Admin already exists");
    process.exit(0);
  }

  const hash = await bcrypt.hash("Admin@123", 10);

  await User.create({
    email,
    fullName: "Super Admin",
    passwordHash: hash,
    roles: ["admin"]
  });

  console.log("✅ Admin user created");
  process.exit(0);
}

seedAdmin();
