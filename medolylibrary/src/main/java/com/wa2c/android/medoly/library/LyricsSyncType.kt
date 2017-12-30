package com.wa2c.android.medoly.library

import android.content.Context

/**
 * Lyrics synchronous type.
 */
enum class LyricsSyncType constructor(val nameId: Int) {
    /** Synchronous lyrics.  */
    SYNC(R.string.lyrics_sync_sync),
    /** Asynchronous lyrics.  */
    UNSYNC(R.string.lyrics_sync_unsync);

    /** Get the name.  */
    fun getName(context: Context): String {
        return context.getString(nameId)
    }

}
