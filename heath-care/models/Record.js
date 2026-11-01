import mongoose from "mongoose";

const RecordSchema = new mongoose.Schema({
  patient_id: { type: mongoose.Schema.Types.ObjectId, ref: "User", required: true, index: true },
  data: { type: mongoose.Schema.Types.Mixed, default: {} }, // medical data JSON
  prescriptions: [
    {
      medication: String,
      dosage: String,
      prescribed_by: { type: mongoose.Schema.Types.ObjectId, ref: "User" },
      prescribed_at: { type: Date, default: Date.now }
    }
  ],
  status: { type: String, default: "active" },
  created_at: { type: Date, default: Date.now }
});

export default mongoose.model("Record", RecordSchema);
