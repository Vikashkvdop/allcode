// utils/response.js
exports.success = (res, msg, data = null, code = 200) =>
  res.status(code).json({ success: true, message: msg, data });

exports.error = (res, msg, err = null, code = 500) =>
  res.status(code).json({ success: false, message: msg, error: err });
