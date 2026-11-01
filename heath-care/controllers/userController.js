import User from "../models/User.js";
import bcrypt from "bcrypt";
import AuditLog from "../models/AuditLog.js";

const SALT_ROUNDS = parseInt(process.env.BCRYPT_SALT_ROUNDS || "10", 10);

export async function createUser(req, res) {
  try {
    const { username, role, password } = req.body;
    if (!username || !role) return res.status(400).json({ message: "username and role required" });
    const pwd = password || "ChangeMe123!"; // for seed or default
    const hash = await bcrypt.hash(pwd, SALT_ROUNDS);

    const user = await User.create({
      username,
      password_hash: hash,
      role
    });

    await AuditLog.create({
      user_id: req.user?.id,
      action: "create_user",
      target: user._id.toString(),
      details: { username, role }
    });

    return res.status(201).json({ id: user._id, username: user.username, role: user.role });
  } catch (err) {
    console.error("createUser:", err);
    if (err.code === 11000) return res.status(409).json({ message: "Username already exists" });
    res.status(500).json({ message: "Server error" });
  }
}
