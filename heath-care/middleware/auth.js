import jwt from "jsonwebtoken";
import Permission from "../models/Permission.js";
import AuditLog from "../models/AuditLog.js";

const getJwtSecret = () => {
  if (!process.env.JWT_SECRET) {
    throw new Error("JWT_SECRET is not defined in environment variables");
  }
  return process.env.JWT_SECRET;
};

// default 3600s if not set
const JWT_EXPIRES_IN = process.env.JWT_EXPIRES_IN || "3600s";

// --- SIGN TOKEN ---
export const signJwt = (payload, expiresIn = JWT_EXPIRES_IN) => {
  return jwt.sign(payload, getJwtSecret(), { expiresIn });
};

// --- VERIFY TOKEN ---
export const verifyToken = async (req, res, next) => {
  try {
    const auth = req.headers.authorization;
    if (!auth || !auth.startsWith("Bearer ")) {
      return res.status(401).json({ message: "Missing token" });
    }

    const token = auth.split(" ")[1];
    const decoded = jwt.verify(token, getJwtSecret());

    req.user = {
      id: decoded.sub,
      role: decoded.role,
      permissions: decoded.permissions || [],
      emergency: decoded.emergency || false,
    };

    // Audit log
    await AuditLog.create({
      user_id: req.user.id,
      action: "token_use",
      target: req.originalUrl,
      details: { role: req.user.role, emergency: req.user.emergency },
    });

    next();
  } catch (err) {
    console.error("verifyToken:", err);
    return res.status(401).json({ message: "Invalid or expired token" });
  }
};

// --- PERMISSION CHECK ---
export const requirePermission = (permission) => {
  return (req, res, next) => {
    if (!req.user) return res.status(401).json({ message: "Not authenticated" });

    if (
      req.user.permissions.includes(permission) ||
      (req.user.emergency === true && permission === "view_records")
    ) {
      return next();
    }
    return res.status(403).json({ message: "Forbidden - insufficient permissions" });
  };
};

// --- ROLE CHECK ---
export const requireRole = (roles) => (req, res, next) => {
  if (!req.user) return res.status(401).json({ message: "Not authenticated" });
  if (roles.includes(req.user.role) || req.user.emergency === true) return next();
  return res.status(403).json({ message: "Forbidden - wrong role" });
};
