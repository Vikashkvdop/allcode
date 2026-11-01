import mongoose from "mongoose";

const UserSchema = new mongoose.Schema({
  username: { type: String, unique: true, required: true, index: true },
  password_hash: { type: String, required: true },
  role: { type: String, enum: ["Patient", "Nurse", "Doctor", "Administrator"], required: true },
  created_at: { type: Date, default: Date.now },
  // additional profile fields could go here (encrypted if sensitive)
});

export default mongoose.model("User", UserSchema);
