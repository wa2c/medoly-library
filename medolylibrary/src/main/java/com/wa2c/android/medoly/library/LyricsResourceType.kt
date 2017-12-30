package com.wa2c.android.medoly.library

import android.content.Context

/**
 * Lyrics resource type.
 */
enum class LyricsResourceType constructor(val nameId: Int) {
    /** Built-in lyrics.  */
    INTERNAL(R.string.lyrics_resource_internal),
    /** External file lyrics.  */
    EXTERNAL(R.string.lyrics_resource_file),
    /** External service lyrics.  */
    SERVICE(R.string.lyrics_resource_service);

    /** Get the name.  */
    fun getName(context: Context): String {
        return context.getString(nameId)
    }

}