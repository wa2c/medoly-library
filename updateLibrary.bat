cd /d %~dp0
./gradlew clean build publish
./gradlew publishMavenPublicationToProjectLocalRepository
