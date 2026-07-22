import express from "express";
import dotenv from "dotenv";
import cors from "cors";
import helmet from "helmet";
import compression from "compression";
import cookieParser from "cookie-parser";
import morgan from "morgan";
import rateLimit from "express-rate-limit";

dotenv.config();

const app = express();

// ===========================
// Security
// ===========================
app.use(helmet());

// ===========================
// Compression
// ===========================
app.use(compression());

// ===========================
// CORS
// ===========================
app.use(
    cors({
        origin: process.env.CLIENT_URL || "*",
        credentials: true
    })
);

// ===========================
// Parsers
// ===========================
app.use(express.json({ limit: "50mb" }));
app.use(express.urlencoded({ extended: true }));
app.use(cookieParser());

// ===========================
// Logger
// ===========================
app.use(morgan("dev"));

// ===========================
// Rate Limiter
// ===========================
const limiter = rateLimit({
    windowMs: 15 * 60 * 1000,
    max: 300,
    message: {
        success: false,
        message: "Too many requests. Please try again later."
    }
});

app.use(limiter);

// ===========================
// Static Files
// ===========================
app.use("/uploads", express.static("src/uploads"));
app.use("/public", express.static("public"));

// ===========================
// Health Check
// ===========================
app.get("/", (req, res) => {
    res.json({
        success: true,
        project: "WebIntoApp Clone Backend",
        version: "1.0.0",
        status: "Running",
        uptime: process.uptime()
    });
});

// ===========================
// API Test
// ===========================
app.get("/api", (req, res) => {
    res.json({
        success: true,
        message: "API Working Successfully"
    });
});

// ===========================
// 404
// ===========================
app.use((req, res) => {
    res.status(404).json({
        success: false,
        message: "Route Not Found"
    });
});

// ===========================
// Error Handler
// ===========================
app.use((err, req, res, next) => {

    console.error(err);

    res.status(err.status || 500).json({
        success: false,
        message: err.message || "Internal Server Error"
    });

});

// ===========================
// Server
// ===========================
const PORT = process.env.PORT || 5000;

app.listen(PORT, () => {

    console.log("=================================");
    console.log("🚀 WebIntoApp Backend Started");
    console.log(`🌍 http://localhost:${PORT}`);
    console.log("=================================");

});