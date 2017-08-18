package com.wa2c.android.medoly.library;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Lyrics synchronous type.
 */
public enum LyricsSyncType {
    /** Synchronous lyrics. */
    SYNC(R.string.lyrics_sync_sync),
    /** Asynchronous lyrics. */
    UNSYNC(R.string.lyrics_sync_unsync);



    /** Constructor. */
    LyricsSyncType(int id) { this.nameId = id; }

    /** Name id. */
    private int nameId;

    /** Get the name id. */
    public int getNameId() { return nameId; }
    /** Get the name. */
    public String getName(@NonNull Context context) {
        return context.getString(nameId);
    }

}
