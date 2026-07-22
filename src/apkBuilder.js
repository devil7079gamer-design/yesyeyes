import fs from "fs/promises";
import path from "path";
import { exec } from "child_process";
import { promisify } from "util";
import { prisma } from "../config/database.js";

const execute = promisify(exec);

const TEMPLATE_PATH = process.env.ANDROID_TEMPLATE;
const OUTPUT_PATH = process.env.OUTPUT_DIRECTORY;

// ============================================
// Copy Android Template
// ============================================

export async function copyTemplate(appId) {

    const source = TEMPLATE_PATH;

    const destination = path.join(
        OUTPUT_PATH,
        appId
    );

    await fs.cp(
        source,
        destination,
        {
            recursive: true
        }
    );

    return destination;

}
// ============================================
// Replace Website URL
// ============================================

export async function replaceWebsiteUrl(

    projectPath,

    websiteUrl

) {

    const file = path.join(

        projectPath,

        "app",

        "src",

        "main",

        "assets",

        "config.json"

    );

    let content = await fs.readFile(

        file,

        "utf8"

    );

    content = content.replace(

        "__WEBSITE_URL__",

        websiteUrl

    );

    await fs.writeFile(

        file,

        content

    );

}
// ============================================
// Replace Package Name
// ============================================

export async function replacePackageName(

    projectPath,

    packageName

) {

    const gradle = path.join(

        projectPath,

        "app",

        "build.gradle"

    );

    let content = await fs.readFile(

        gradle,

        "utf8"

    );

    content = content.replace(

        /com\.example\.webintoapp/g,

        packageName

    );

    await fs.writeFile(

        gradle,

        content

    );

}
// ============================================
// Replace Application Name
// ============================================

export async function replaceAppName(
    projectPath,
    appName
) {

    const stringsFile = path.join(
        projectPath,
        "app",
        "src",
        "main",
        "res",
        "values",
        "strings.xml"
    );

    let content = await fs.readFile(
        stringsFile,
        "utf8"
    );

    content = content.replace(
        "__APP_NAME__",
        appName
    );

    await fs.writeFile(
        stringsFile,
        content
    );

}
// ============================================
// Replace App Icon
// ============================================

export async function replaceIcon(
    projectPath,
    iconPath
) {

    const iconFolders = [

        "mipmap-mdpi",
        "mipmap-hdpi",
        "mipmap-xhdpi",
        "mipmap-xxhdpi",
        "mipmap-xxxhdpi"

    ];

    for (const folder of iconFolders) {

        const destination = path.join(
            projectPath,
            "app",
            "src",
            "main",
            "res",
            folder,
            "ic_launcher.png"
        );

        await fs.copyFile(
            iconPath,
            destination
        );

    }

}
// ============================================
// Replace Splash Screen
// ============================================

export async function replaceSplash(
    projectPath,
    splashPath
) {

    const destination = path.join(
        projectPath,
        "app",
        "src",
        "main",
        "res",
        "drawable",
        "splash.png"
    );

    await fs.copyFile(
        splashPath,
        destination
    );

}
// ============================================
// Build APK
// ============================================

export async function buildAPK(projectPath) {

    const command =
        process.platform === "win32"
            ? "gradlew.bat assembleRelease"
            : "./gradlew assembleRelease";

    await execute(command, {
        cwd: projectPath
    });

}
// ============================================
// Find Generated APK
// ============================================

export async function findGeneratedAPK(projectPath) {

    const apk = path.join(

        projectPath,

        "app",

        "build",

        "outputs",

        "apk",

        "release",

        "app-release.apk"

    );

    try {

        await fs.access(apk);

        return apk;

    }

    catch {

        return null;

    }

}
// ============================================
// Save Build History
// ============================================

export async function saveBuildHistory(

    appId,

    status,

    apkUrl,

    buildLog

) {

    return prisma.build.create({

        data: {

            appId,

            status,

            apkUrl,

            buildLog

        }

    });

}
// ============================================
// Complete Build
// ============================================

export async function completeBuild(

    appId,

    apkPath

) {

    await prisma.app.update({

        where: {

            id: appId

        },

        data: {

            status: "SUCCESS",

            apkUrl: apkPath

        }

    });

}
// ============================================
// Failed Build
// ============================================

export async function failedBuild(

    appId,

    error

) {

    await prisma.app.update({

        where: {

            id: appId

        },

        data: {

            status: "FAILED"

        }

    });

    await prisma.build.create({

        data: {

            appId,

            status: "FAILED",

            buildLog: error.toString()

        }

    });

}
// ============================================
// Main Builder
// ============================================

export async function generateAPK(app) {

    try {

        const project = await copyTemplate(app.id);

        await replaceWebsiteUrl(
            project,
            app.websiteUrl
        );

        await replacePackageName(
            project,
            app.packageName
        );

        await replaceAppName(
            project,
            app.appName
        );

        if (app.icon)
            await replaceIcon(
                project,
                app.icon
            );

        if (app.splashScreen)
            await replaceSplash(
                project,
                app.splashScreen
            );

        await buildAPK(project);

        const apk = await findGeneratedAPK(project);

        if (!apk)
            throw new Error("APK Not Generated");

        await completeBuild(
            app.id,
            apk
        );

        await saveBuildHistory(
            app.id,
            "SUCCESS",
            apk,
            "Build Successful"
        );

        return apk;

    }

    catch (error) {

        await failedBuild(
            app.id,
            error
        );

        throw error;

    }

}