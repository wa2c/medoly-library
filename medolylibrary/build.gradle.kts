plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    `maven-publish`
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


// Maven publish
val repo = File(rootDir, "repository")
val artifactId = "medolylibrary"
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.wa2c.android"
            artifactId = artifactId
            version = libs.versions.appVersion.get()
            artifact("${project.layout.buildDirectory.get()}/outputs/aar/$artifactId-release.aar")
        }
    }
    repositories {
        maven {
            name = "ProjectLocal"
            url = uri("file://${repo.absolutePath}")
        }
    }
}
