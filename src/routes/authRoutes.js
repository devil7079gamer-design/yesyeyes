import express from "express";

import {
    register,
    login,
    profile
} from "../controllers/authController.js";

import authMiddleware from "../middleware/auth.js";

const router = express.Router();

// =========================
// Authentication
// =========================

// Register
router.post("/register", register);

// Login
router.post("/login", login);

// Current User Profile
router.get("/profile", authMiddleware, profile);

export default router;