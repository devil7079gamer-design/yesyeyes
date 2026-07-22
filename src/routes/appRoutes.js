import express from "express";

import authMiddleware from "../middleware/auth.js";

import {
    createApp,
    getApps,
    getApp,
    updateApp,
    deleteApp
} from "../controllers/appController.js";

const router = express.Router();

// Create App
router.post("/create", authMiddleware, createApp);

// Get All Apps
router.get("/", authMiddleware, getApps);

// Get Single App
router.get("/:id", authMiddleware, getApp);

// Update App
router.put("/:id", authMiddleware, updateApp);

// Delete App
router.delete("/:id", authMiddleware, deleteApp);

export default router;