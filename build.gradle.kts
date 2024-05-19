// Top-level build file where you can add configuration options common to all sub-projects/modules.

val applicationId by extra ("com.wa2c.android.medoly.library")
val javaVersion by extra (JavaVersion.VERSION_17)

// Plugins
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
