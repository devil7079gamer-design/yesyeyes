plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.vex_app"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        // 🚀 Enable Core Library Desugaring for Notifications
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig {
        applicationId = "com.example.vex_app"
        minSdk = 21
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    // 🔑 Dynamic Release Signing Configuration
    signingConfigs {
        create("release") {
            storeFile = file("vex-key.jks")
            storePassword = "VexAppPass123"
            keyAlias = "vexkey"
            keyPassword = "VexAppPass123"
        }
    }

    buildTypes {
        getByName("release") {
            // Debug key remove karke release key attach kar di hai
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // 🚀 Core Library Desugaring Support (Kotlin Syntax)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
}
