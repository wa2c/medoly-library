Medoly Library
==============

This is  a library for [Medoly](https://play.google.com/store/apps/details?id=com.wa2c.android.medoly) plugins development.  
This provides plugin interfaces and common classes.

## Building

Run gradle build to build. 

## Usage

Add followings to build.gradle.

    repositories {
        maven { url 'https://github.com/wa2c/medoly-library/raw/master/repository/' }
    }

    dependencies {
        `compile 'com.wa2c.android:medolylibrary:1.2.4'`
    }

## Sample

See following projects.

* [Medoly Last.fm Plugin](https://github.com/wa2c/medoly-lastfm-plugin)
* [Medoly Twitter Plugin](https://github.com/wa2c/medoly-twitter-plugin)
* [Medoly Lyrics Scraper Plugin](https://github.com/wa2c/medoly-lyrics-scraper-plugin)
* [Medoly LRC Lyrics Plugin](https://github.com/wa2c/medoly-lrc-lyrics-plugin)

## Licence

[MIT](https://raw.githubusercontent.com/wa2c/medoly-library/master/LICENSE.txt)

## Author

[wa2c](https://github.com/wa2c)
