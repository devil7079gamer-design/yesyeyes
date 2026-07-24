plugins {
    id "com.android.application"
    id "org.jetbrains.kotlin.android"
    id "dev.flutter.flutter-gradle-plugin"
}

android {
    namespace "__PACKAGE_NAME__"

    compileSdk 35

    defaultConfig {
        applicationId "__PACKAGE_NAME__"

        minSdk 24
        targetSdk 35

        versionCode 1
        versionName "1.0.0"

        multiDexEnabled true
    }

    signingConfigs {
        release {
            // Builder will inject keystore here
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            shrinkResources false

            signingConfig signingConfigs.debug
        }

        debug {
            minifyEnabled false
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig true
    }
}

flutter {
    source "../.."
}

dependencies {

    implementation "androidx.multidex:multidex:2.0.1"

}