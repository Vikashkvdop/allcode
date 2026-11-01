import express from "express";
import { login } from "../controllers/authController.js";

const router = express.Router();

/**
 * POST /auth/login
 * body: { username, password }
 */
router.post("/login", login);

export default router;
