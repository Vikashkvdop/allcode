const express = require("express");
const router = express.Router();


const { auth, isNurse, isDoctor } = require("../middlewares/auth");
const { addCondition, getPatientConditions } = require("../controllers/conditionController");

// Nurse adds patient condition
router.post("/add", auth, isNurse, addCondition);

//  Doctor views conditions of a patient
router.get("/patient/:patientId", auth, isDoctor, getPatientConditions);

module.exports = router;
