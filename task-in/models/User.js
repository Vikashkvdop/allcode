const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
  email: { type: String, unique: true, required: true },
  fullName: { type: String, required: true },
  passwordHash: { type: String, required: true },
  roles: { type: [String], default: [] },
  classId: Number,
  children: [{ type: mongoose.Schema.Types.ObjectId, ref: "User" }],
  phone: String,
  address: String,
  createdAt: { type: Date, default: Date.now },
  updatedAt: Date
});

module.exports = mongoose.model("User", userSchema);
