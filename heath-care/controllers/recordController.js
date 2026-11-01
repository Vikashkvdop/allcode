import Record from "../models/Record.js";
import User from "../models/User.js";
import AuditLog from "../models/AuditLog.js";
import { signJwt } from "../middleware/auth.js";

const EMERGENCY_EXP = parseInt(process.env.EMERGENCY_TOKEN_EXPIRES || "300", 10);
const JWT_EXPIRES_IN = process.env.JWT_EXPIRES_IN || "3600";

export async function getRecords(req, res) {
  try {
    const { patient_id } = req.params;
    const requester = req.user;

    // Patients can only access their own records
    if (requester.role === "Patient" && requester.id !== patient_id) {
      return res.status(403).json({ message: "Patients can only access their own records" });
    }

    // nurses/doctors/admins with permission are allowed
    const record = await Record.findOne({ patient_id }).lean();
    if (!record) return res.status(404).json({ message: "No record found" });

    await AuditLog.create({
      user_id: requester.id,
      action: "view_records",
      target: patient_id,
      details: { role: requester.role, emergency: requester.emergency }
    });

    return res.json({ patient_id, records: record });
  } catch (err) {
    console.error("getRecords:", err);
    res.status(500).json({ message: "Server error" });
  }
}

export async function updateStatus(req, res) {
  try {
    const { patient_id } = req.params;
    const { status } = req.body;
    if (!status) return res.status(400).json({ message: "status required" });

    const updated = await Record.findOneAndUpdate({ patient_id }, { status }, { new: true });
    if (!updated) return res.status(404).json({ message: "Record not found" });

    await AuditLog.create({
      user_id: req.user.id,
      action: "update_status",
      target: patient_id,
      details: { status }
    });

    return res.status(204).send();
  } catch (err) {
    console.error("updateStatus:", err);
    res.status(500).json({ message: "Server error" });
  }
}

export async function prescribeMedication(req, res) {
  try {
    const { patient_id } = req.params;
    const { medication, dosage } = req.body;
    if (!medication || !dosage) return res.status(400).json({ message: "medication and dosage required" });

    const record = await Record.findOne({ patient_id });
    if (!record) return res.status(404).json({ message: "Record not found" });

    record.prescriptions.push({
      medication,
      dosage,
      prescribed_by: req.user.id,
      prescribed_at: new Date()
    });

    await record.save();

    await AuditLog.create({
      user_id: req.user.id,
      action: "prescribe_medication",
      target: patient_id,
      details: { medication, dosage }
    });

    return res.status(201).json({ message: "Prescription added" });
  } catch (err) {
    console.error("prescribeMedication:", err);
    res.status(500).json({ message: "Server error" });
  }
}

// Emergency access: Doctor can request short-lived emergency token for viewing records of patient (must be logged)
export async function requestEmergencyAccess(req, res) {
  try {
    const { patient_id } = req.params;
    // Only Doctors allowed to request emergency token (we'll enforce via route middleware)
    const justCause = req.body.reason || "emergency";

    const payload = {
      sub: req.user.id,
      role: req.user.role,
      permissions: req.user.permissions,
      emergency: true,
      patient_target: patient_id
    };

    const token = signJwt(payload, `${EMERGENCY_EXP}s`);

    await AuditLog.create({
      user_id: req.user.id,
      action: "emergency_request",
      target: patient_id,
      details: { reason: justCause, issued_for_seconds: EMERGENCY_EXP }
    });

    return res.json({ emergency_token: token, expires_in: EMERGENCY_EXP });
  } catch (err) {
    console.error("requestEmergencyAccess:", err);
    res.status(500).json({ message: "Server error" });
  }
}
