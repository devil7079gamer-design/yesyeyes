import { PrismaClient } from "@prisma/client";

const globalForPrisma = globalThis;

export const prisma =
    globalForPrisma.prisma ||
    new PrismaClient({
        log: ["error", "warn"]
    });

if (process.env.NODE_ENV !== "production") {
    globalForPrisma.prisma = prisma;
}

// Database Connection Test
export async function connectDatabase() {
    try {
        await prisma.$connect();

        console.log("=================================");
        console.log("✅ PostgreSQL Connected");
        console.log("=================================");

    } catch (error) {

        console.error("=================================");
        console.error("❌ Database Connection Failed");
        console.error(error);
        console.error("=================================");

        process.exit(1);
    }
}

// Gracefully disconnect
export async function disconnectDatabase() {
    try {
        await prisma.$disconnect();
        console.log("📦 Database Disconnected");
    } catch (error) {
        console.error(error);
    }
}