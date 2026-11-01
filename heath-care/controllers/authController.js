import User from "../models/User.js";
import Permission from "../models/Permission.js";
import bcrypt from "bcrypt";
import { signJwt } from "../middleware/auth.js";
import AuditLog from "../models/AuditLog.js";

const JWT_EXPIRES_IN = process.env.JWT_EXPIRES_IN || "3600";

export async function login(req, res) {
  try {
    const { username, password } = req.body;
    if (!username || !password) {
      return res.status(400).json({ message: "username and password required" });
    }

    const user = await User.findOne({ username });
    if (!user) return res.status(401).json({ message: "Invalid credentials" });

    const ok = await bcrypt.compare(password, user.password_hash);
    if (!ok) return res.status(401).json({ message: "Invalid credentials" });

    // get permissions for role
    const p = await Permission.findOne({ role: user.role });
    const permissions = p ? p.permissions : [];

    const payload = {
      sub: user._id.toString(),
      role: user.role,
      permissions,
    };

    // use helper to sign token
    const token = signJwt(payload, `${JWT_EXPIRES_IN}s`);

    // Audit
    await AuditLog.create({
      user_id: user._id,
      action: "login",
      target: "auth/login",
      details: { role: user.role },
    });

    return res.json({
      access_token: token,
      expires_in: parseInt(JWT_EXPIRES_IN, 10),
    });
  } catch (err) {
    console.error("login error:", err);
    res.status(500).json({ message: "Server error" });
  }
}
