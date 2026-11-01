const Condition = require("../models/Condition");

// Nurse adds patient condition
exports.addCondition = async (req, res) => {
  try {
    const { patientId, description, severity } = req.body;

    if (!patientId || !description) {
      return res
        .status(400)
        .json({ success: false, message: "Patient and description are required" });
    }

    const condition = await Condition.create({
      patient: patientId,
      nurse: req.user.id,
      description,
      severity,
    });

    res.status(201).json({ success: true, condition });
  } catch (error) {
    console.error("Error adding condition:", error);
    res.status(500).json({ success: false, message: "Server error" });
  }
};

// Doctor views conditions of a patient
exports.getPatientConditions = async (req, res) => {
  try {
    const { patientId } = req.params;

    const conditions = await Condition.find({ patient: patientId })
      .populate("nurse", "name email")
      .populate("patient", "name email");

    res.status(200).json({ success: true, conditions });
  } catch (error) {
    console.error("Error fetching conditions:", error);
    res.status(500).json({ success: false, message: "Server error" });
  }
};
