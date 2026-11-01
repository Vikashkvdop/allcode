import mongoose from "mongoose";

const AuditLogSchema = new mongoose.Schema({
  user_id: { type: mongoose.Schema.Types.ObjectId, ref: "User" },
  action: String,
  target: String,
  details: mongoose.Schema.Types.Mixed,
  timestamp: { type: Date, default: Date.now }
});

export default mongoose.model("AuditLog", AuditLogSchema);
