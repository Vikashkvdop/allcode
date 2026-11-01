import express from "express";
import { createUser } from "../controllers/userController.js";
import { verifyToken, requirePermission } from "../middleware/auth.js";

const router = express.Router();

/**
 * POST /users
 * Body: { username, role, password? }
 * Requires manage_users permission
 */
router.post("/", verifyToken, requirePermission("manage_users"), createUser);

export default router;
