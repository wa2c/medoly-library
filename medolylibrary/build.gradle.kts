//apply from: 'maven-push.gradle'

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
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
        minSdk = libs.versions.androidMinSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.txt")
        }
    }
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.robolectric)
}
