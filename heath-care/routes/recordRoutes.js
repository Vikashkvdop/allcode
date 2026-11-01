import express from "express";
import {
  getRecords,
  updateStatus,
  prescribeMedication,
  requestEmergencyAccess
} from "../controllers/recordController.js";
import { verifyToken, requirePermission, requireRole } from "../middleware/auth.js";

const router = express.Router();

/**
 * GET /records/:patient_id
 * Roles: Patient(own), Nurse, Doctor, Administrator
 * Permission: view_records
 */
router.get("/:patient_id", verifyToken, requirePermission("view_records"), getRecords);

/**
 * PATCH /records/:patient_id/status
 * Roles: Nurse, Doctor
 * Permission: update_status
 */
router.patch("/:patient_id/status", verifyToken, requirePermission("update_status"), updateStatus);

/**
 * POST /records/:patient_id/prescriptions
 * Roles: Doctor
 * Permission: prescribe_medication
 */
router.post("/:patient_id/prescriptions", verifyToken, requirePermission("prescribe_medication"), prescribeMedication);

/**
 * POST /records/:patient_id/emergency-access
 * Roles: Doctor
 * Returns a short-lived emergency token to view records (must be logged and audited)
 */
router.post("/:patient_id/emergency-access", verifyToken, requirePermission("request_emergency_access"), requestEmergencyAccess);

export default router;
