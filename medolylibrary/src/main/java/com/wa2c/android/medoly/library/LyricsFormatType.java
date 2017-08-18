package com.wa2c.android.medoly.library;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Lyrics format type.
 */
public enum LyricsFormatType {
    /** Plain text. */
    TEXT(R.string.lyrics_format_text, "text/plain"),
    /** LRC format. */
    LRC(R.string.lyrics_format_lrc, "text/plain"),
    /** KRA (Karaoke) format. */
    KRA(R.string.lyrics_format_kra, "text/plain"),
    /** JoyHack format. */
    JOYHACK(R.string.lyrics_format_joyhack, "text/plain"),
    /** SRT (SubRip) format. */
    SRT(R.string.lyrics_format_srt, "text/srt"),
    /** STL (Spruce subtitle) format. */
    STL(R.string.lyrics_format_stl, "application/octet-stream"),
    /** SCC (Scenarist Closed Caption) format. */
    SCC(R.string.lyrics_format_scc, "text/plain"),
    /** SSA/ASS (SubStation Alpha) format. */
    ASS(R.string.lyrics_format_ass, "application/x-ass"),
    /** TTML (Timed Text Markup Language) format. */
    TTML(R.string.lyrics_format_ttml, "application/ttml+xml"),

    /** Built-in lyrics field. */
    LYRICS(R.string.lyrics_format_lyrics, null),
    /** SYLT field. */
    SYLT(R.string.lyrics_format_sylt, null),
    /** MP3 Lyrics3 v1 field. */
    MP3_LYRICS3V1(R.string.lyrics_format_mp3_lyrics3v1, null),
    /** MP3 Lyrics3 v2 field. */
    MP3_LYRICS3V2(R.string.lyrics_format_mp3_lyrics3v2, null);



    /** Constructor. */
    LyricsFormatType(int id, String mimeType) {
        this.nameId = id;
        this.mimeType = mimeType;
    }

    /** Name id. */
    private int nameId;
    /** MIME Type */
    private String mimeType;

    /** Get the name id. */
    public int getNameId() { return nameId; }
    /** Get the name. */
    public String getName(@NonNull Context context) {
        return context.getString(nameId);
    }
    /** Get the MIME Type. */
    public String getMimeType() { return mimeType; }

}

