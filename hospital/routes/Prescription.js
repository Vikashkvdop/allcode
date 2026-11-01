const express = require("express");
const { addPrescription, getDoctorPrescriptions, getPatientPrescriptions } = require("../controllers/prescriptionController");
const { auth, isDoctor, isPatient } = require("../middlewares/auth");


const router = express.Router();

// Only doctors can add prescriptions
router.post("/addPrescription", auth, isDoctor, addPrescription);

// Doctor can view their own prescriptions
router.get("/doctor", auth, isDoctor, getDoctorPrescriptions);

// Patient can view their prescriptions
router.get("/patient", auth, isPatient, getPatientPrescriptions);

module.exports = router;
