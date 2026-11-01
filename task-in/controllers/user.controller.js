const User = require('../models/User');
const Audit = require('../models/AuditLog');
const bcrypt = require('bcrypt');
const { generateToken } = require('../utils/jwt');

// ---------------- REGISTER ----------------
exports.register = async (req, res) => {
  const { email, fullName, password, role, classId } = req.body;

  if (!email || !password || !fullName || !role)
    return res.status(400).json({ message: "Missing fields" });

  const exists = await User.findOne({ email });
  if (exists) return res.status(409).json({ message: "Email already exists" });

  // RBAC
  if (req.user.roles.includes("teacher") && role !== "student")
    return res.status(403).json({ message: "Teacher can only create students" });

  if (!req.user.roles.includes("admin") && ["teacher", "parent"].includes(role))
    return res.status(403).json({ message: "Only admin can create teacher or parent" });

  const hash = await bcrypt.hash(password, 10);

  const user = await User.create({
    email,
    fullName,
    passwordHash: hash,
    roles: [role],
    classId
  });

  await Audit.create({
    event: "USER_REGISTER",
    userId: user._id,
    updatedBy: req.user.sub
  });

  const token = generateToken(user);

  res.status(201).json({
    id: user._id,
    email: user.email,
    fullName: user.fullName,
    role: role,
    token
  });
};

// ---------------- LOGIN ----------------
exports.login = async (req, res) => {
  const { email, password } = req.body;
  if (!email || !password)
    return res.status(400).json({ message: "Email & password required" });

  const user = await User.findOne({ email });
  if (!user) return res.status(401).json({ message: "Invalid credentials" });

  const ok = await bcrypt.compare(password, user.passwordHash);
  if (!ok) return res.status(401).json({ message: "Invalid credentials" });

  const token = generateToken(user);

  res.json({
    token,
    user: {
      id: user._id,
      email: user.email,
      fullName: user.fullName,
      roles: user.roles
    }
  });
};

// ---------------- GET USER ----------------
exports.getUser = async (req, res) => {
  const user = await User.findById(req.params.id).select("-passwordHash");
  if (!user) return res.status(404).json({ message: "User not found" });

  const requester = req.user;

  if (requester.roles.includes("admin")) return res.json(user);

  if (requester.sub !== user.id)
    return res.status(403).json({ message: "Forbidden" });

  res.json(user);
};

// ---------------- UPDATE USER ----------------
exports.updateUser = async (req, res) => {
  const user = await User.findById(req.params.id);
  if (!user) return res.status(404).json({ message: "User not found" });

  if (req.user.sub !== user.id && !req.user.roles.includes("admin"))
    return res.status(403).json({ message: "Forbidden" });

  const oldData = { phone: user.phone, address: user.address };

  user.phone = req.body.phone ?? user.phone;
  user.address = req.body.address ?? user.address;
  user.updatedAt = new Date();
  await user.save();

  await Audit.create({
    event: "USER_PROFILE_UPDATE",
    userId: user._id,
    updatedBy: req.user.sub,
    changes: { old: oldData, new: req.body }
  });

  res.json(user);
};

// ---------------- UPDATE ROLES ----------------
exports.updateRoles = async (req, res) => {
  if (!req.user.roles.includes("admin"))
    return res.status(403).json({ message: "Only admin allowed" });

  const user = await User.findById(req.params.id);
  if (!user) return res.status(404).json({ message: "User not found" });

  const oldRoles = user.roles;
  user.roles = req.body.roles;
  await user.save();

  await Audit.create({
    event: "USER_ROLE_UPDATE",
    userId: user._id,
    updatedBy: req.user.sub,
    oldRoles,
    newRoles: req.body.roles
  });

  res.json({ id: user._id, roles: user.roles });
};
