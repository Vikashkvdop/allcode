const Prescription = require("../models/Prescription");
const User = require("../models/user");

// Doctor creates prescription
exports.addPrescription = async (req, res) => {
  try {
    const { patientId, medicines, notes } = req.body;

    const patient = await User.findById(patientId);
    if (!patient || patient.accountType !== "Patient") {
      return res.status(404).json({ success: false, message: "Patient not found" });
    }

    const prescription = await Prescription.create({
      doctor: req.user.id,
      patient: patientId,
      medicines,
      notes
    });

    res.status(201).json({ success: true, message: "Prescription added", prescription });
  } catch (err) {
    console.error("Add prescription error:", err);
    res.status(500).json({ success: false, message: "Failed to add prescription" });
  }
};

// Doctor views all prescriptions they created
exports.getDoctorPrescriptions = async (req, res) => {
  try {
    const prescriptions = await Prescription.find({ doctor: req.user.id })
      .populate("patient", "name email");

    res.json({ success: true, prescriptions });
  } catch (err) {
    res.status(500).json({ success: false, message: "Failed to fetch prescriptions" });
  }
};

// Patient views their prescriptions
exports.getPatientPrescriptions = async (req, res) => {
  try {
    const prescriptions = await Prescription.find({ patient: req.user.id })
      .populate("doctor", "name email");

    res.json({ success: true, prescriptions });
  } catch (err) {
    res.status(500).json({ success: false, message: "Failed to fetch prescriptions" });
  }
};
