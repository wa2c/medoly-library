@echo off
cd /d %~dp0
./gradlew clean build
./gradlew publishMavenPublicationToProjectLocalRepository
