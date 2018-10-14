Medoly Library
==============

本プログラムは、[Medoly](https://play.google.com/store/apps/details?id=com.wa2c.android.medoly)のプラグイン開発向けライブラリです。  
プラグイン用インターフェースや共通クラスを提供します。

## ビルド

Gradleを実行してください。

## 使い方

次の記述をbuild.gradleファイルに追加してください。

```gradle
    repositories {
        maven { url 'https://github.com/wa2c/medoly-library/raw/master/repository/' }
    }

    dependencies {
        implementation 'com.wa2c.android:medolylibrary:1.2.4'
    }
```

## サンプル

次のプロジェクトを参考にしてください。

* [Medoly Last.fm Plugin](https://github.com/wa2c/medoly-lastfm-plugin)
* [Medoly Twitter Plugin](https://github.com/wa2c/medoly-twitter-plugin)
* [Medoly Lyrics Scraper Plugin](https://github.com/wa2c/medoly-lyrics-scraper-plugin)
* [Medoly LRC Lyrics Plugin](https://github.com/wa2c/medoly-lrc-lyrics-plugin)

## ライセンス

[MIT](https://raw.githubusercontent.com/wa2c/medoly-library/master/LICENSE.txt)

## 作者

[wa2c](https://github.com/wa2c)
