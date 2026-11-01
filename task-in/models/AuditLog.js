const mongoose = require('mongoose');

const auditSchema = new mongoose.Schema({
  event: String,
  timestamp: { type: Date, default: Date.now },
  userId: mongoose.Schema.Types.ObjectId,
  updatedBy: mongoose.Schema.Types.ObjectId,
  changes: Object
});

module.exports = mongoose.model("AuditLog", auditSchema);
