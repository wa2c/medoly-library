Medoly Library
==============

This is  a library for [Medoly](https://play.google.com/store/apps/details?id=com.wa2c.android.medoly) plugins development.  
This provides plugin interfaces and common classes.

## Building

Run gradle build to build. 

## Usage

Add followings to build.gradle.

    repositories {
        maven { url 'https://api.bitbucket.org/1.0/repositories/wa2c/medoly-library/raw/master/repository/' }
    }

    dependencies {
        `compile 'com.wa2c.android:medolylibrary:1.1.0'`
    }

## Sample

See following projects.

* [Medoly Last.fm Plugin](https://bitbucket.org/wa2c/medoly-last.fm-scrobbler-plugin)
* [Medoly Twitter Plugin](https://bitbucket.org/wa2c/medoly-twitter-plugin)
* [Medoly Lyrics Scraper Plugin](https://bitbucket.org/wa2c/medoly-lyrics-scraper-plugin)
* [Medoly LRC Lyrics Plugin](https://bitbucket.org/wa2c/medoly-lrc-lyrics-plugin)

## Licence

[MIT](https://bitbucket.org/wa2c/medoly-library/raw/517df9165aa19fe335046be0611d58ca135ff37a/LICENSE.txt)

## Author

[wa2c](https://bitbucket.org/wa2c/)
