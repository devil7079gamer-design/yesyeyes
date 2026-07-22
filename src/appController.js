import { prisma } from "../config/database.js";
import fs from "fs";
import path from "path";
import { v4 as uuid } from "uuid";

// =========================================
// Create New App
// =========================================
export const createApp = async (req, res) => {

    try {

        const {
            appName,
            packageName,
            websiteUrl,
            themeColor
        } = req.body;

        if (
            !appName ||
            !packageName ||
            !websiteUrl
        ) {

            return res.status(400).json({
                success: false,
                message: "All fields are required."
            });

        }

        // Check Package Name

        const packageExists = await prisma.app.findUnique({

            where: {
                packageName
            }

        });

        if (packageExists) {

            return res.status(409).json({

                success: false,
                message: "Package Name already exists."

            });

        }

        // Create Folder

        const appFolder = `uploads/apps/${uuid()}`;

        fs.mkdirSync(appFolder, {
            recursive: true
        });

        // Create App

        const app = await prisma.app.create({

            data: {

                userId: req.user.id,

                appName,

                packageName,

                websiteUrl,

                themeColor,

                status: "DRAFT"

            }

        });

        return res.status(201).json({

            success: true,

            message: "Application Created Successfully.",

            app

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};
// =========================================
// Get User Apps
// =========================================

export const getApps = async (req, res) => {

    try {

        const apps = await prisma.app.findMany({

            where: {

                userId: req.user.id

            },

            orderBy: {

                createdAt: "desc"

            }

        });

        return res.json({

            success: true,

            total: apps.length,

            apps

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error"

        });

    }

};
// =========================================
// Get Single App
// =========================================

export const getApp = async (req, res) => {

    try {

        const { id } = req.params;

        const app = await prisma.app.findFirst({

            where: {
                id,
                userId: req.user.id
            }

        });

        if (!app) {

            return res.status(404).json({

                success: false,

                message: "Application not found."

            });

        }

        return res.json({

            success: true,

            app

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};
// =========================================
// Update App
// =========================================

export const updateApp = async (req, res) => {

    try {

        const { id } = req.params;

        const {

            appName,

            websiteUrl,

            themeColor,

            versionName,

            versionCode

        } = req.body;

        const app = await prisma.app.findFirst({

            where: {

                id,

                userId: req.user.id

            }

        });

        if (!app) {

            return res.status(404).json({

                success: false,

                message: "Application not found."

            });

        }

        const updatedApp = await prisma.app.update({

            where: {

                id

            },

            data: {

                appName,

                websiteUrl,

                themeColor,

                versionName,

                versionCode

            }

        });

        return res.json({

            success: true,

            message: "Application Updated Successfully.",

            app: updatedApp

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};
// =========================================
// Delete App
// =========================================

export const deleteApp = async (req, res) => {

    try {

        const { id } = req.params;

        const app = await prisma.app.findFirst({

            where: {

                id,

                userId: req.user.id

            }

        });

        if (!app) {

            return res.status(404).json({

                success: false,

                message: "Application not found."

            });

        }

        // Delete Builds

        await prisma.build.deleteMany({

            where: {

                appId: app.id

            }

        });

        // Delete App

        await prisma.app.delete({

            where: {

                id: app.id

            }

        });

        return res.json({

            success: true,

            message: "Application Deleted Successfully."

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};
// =========================================
// Upload Icon
// =========================================

export const uploadIcon = async (req, res) => {

    try {

        const { id } = req.params;

        const app = await prisma.app.findFirst({

            where: {

                id,

                userId: req.user.id

            }

        });

        if (!app) {

            return res.status(404).json({

                success: false,

                message: "Application not found."

            });

        }

        if (!req.file) {

            return res.status(400).json({

                success: false,

                message: "No icon uploaded."

            });

        }

        const updated = await prisma.app.update({

            where: {

                id

            },

            data: {

                icon: req.file.filename

            }

        });

        return res.json({

            success: true,

            message: "Icon Uploaded Successfully.",

            app: updated

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};
// =========================================
// Upload Splash Screen
// =========================================

export const uploadSplash = async (req, res) => {

    try {

        const { id } = req.params;

        const app = await prisma.app.findFirst({

            where: {
                id,
                userId: req.user.id
            }

        });

        if (!app) {

            return res.status(404).json({

                success: false,
                message: "Application not found."

            });

        }

        if (!req.file) {

            return res.status(400).json({

                success: false,
                message: "No splash screen uploaded."

            });

        }

        const updated = await prisma.app.update({

            where: {
                id
            },

            data: {
                splashScreen: req.file.filename
            }

        });

        return res.json({

            success: true,
            message: "Splash Screen Uploaded Successfully.",
            app: updated

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,
            message: "Internal Server Error."

        });

    }

};
// =========================================
// Build Application
// =========================================

export const buildApp = async (req, res) => {

    try {

        const { id } = req.params;

        const app = await prisma.app.findFirst({

            where: {
                id,
                userId: req.user.id
            }

        });

        if (!app) {

            return res.status(404).json({

                success: false,
                message: "Application not found."

            });

        }

        // Update Status

        await prisma.app.update({

            where: {
                id
            },

            data: {
                status: "BUILDING"
            }

        });

        // Save Build History

        await prisma.build.create({

            data: {

                appId: app.id,

                status: "BUILDING",

                buildLog: "Build Started..."

            }

        });

        return res.json({

            success: true,

            message: "Application build has started."

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};
// =========================================
// Download APK
// =========================================

export const downloadAPK = async (req, res) => {

    try {

        const { id } = req.params;

        const app = await prisma.app.findFirst({

            where: {

                id,

                userId: req.user.id

            }

        });

        if (!app) {

            return res.status(404).json({

                success: false,

                message: "Application not found."

            });

        }

        if (!app.apkUrl) {

            return res.status(400).json({

                success: false,

                message: "APK is not available yet."

            });

        }

        return res.download(app.apkUrl);

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};
// =========================================
// Build History
// =========================================

export const buildHistory = async (req, res) => {

    try {

        const { id } = req.params;

        const history = await prisma.build.findMany({

            where: {

                appId: id

            },

            orderBy: {

                createdAt: "desc"

            }

        });

        return res.json({

            success: true,

            total: history.length,

            history

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};
// =========================================
// Dashboard Statistics
// =========================================

export const appStatistics = async (req, res) => {

    try {

        const totalApps = await prisma.app.count({

            where: {

                userId: req.user.id

            }

        });

        const successApps = await prisma.app.count({

            where: {

                userId: req.user.id,

                status: "SUCCESS"

            }

        });

        const buildingApps = await prisma.app.count({

            where: {

                userId: req.user.id,

                status: "BUILDING"

            }

        });

        const failedApps = await prisma.app.count({

            where: {

                userId: req.user.id,

                status: "FAILED"

            }

        });

        return res.json({

            success: true,

            statistics: {

                totalApps,

                successApps,

                buildingApps,

                failedApps

            }

        });

    }

    catch (error) {

        console.error(error);

        return res.status(500).json({

            success: false,

            message: "Internal Server Error."

        });

    }

};