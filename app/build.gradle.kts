plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

val applicationId: String by rootProject.extra
val javaVersion: JavaVersion by rootProject.extra

android {
    namespace = applicationId
    compileSdk = libs.versions.androidCompileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    defaultConfig {
        applicationId = applicationId
        minSdk = libs.versions.androidMinSdk.get().toInt()
        targetSdk = libs.versions.androidCompileSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.txt")
        }
    }
}
