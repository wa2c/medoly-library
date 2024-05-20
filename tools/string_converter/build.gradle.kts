@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    kotlin("jvm") version "1.9.24"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.opencsv:opencsv:5.9")
    implementation("org.redundent:kotlin-xml-builder:1.9.1")
}

/**
 * CSV-XML conversion task.
 */
val convertString by tasks.registering(JavaExec::class) {
    group = "tools"
    classpath = java.sourceSets["main"].runtimeClasspath
    mainClass.set("com.wa2c.android.medolylibrary.tools.string_converter.MainKt")
    args(
        File(projectDir, "strings.csv").canonicalPath,
        File(projectDir, "../../medolylibrary/src/main/res/").canonicalPath,
        "https://docs.google.com/spreadsheets/d/1KFJi1-pu8L0QeFX2RKw4CeeJ5X8NLP4CcTkQfnq3NNo/export?format=csv&gid=46458173"
    )
}
