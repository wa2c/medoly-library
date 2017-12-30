package com.wa2c.android.medoly.library

import android.content.Context

/**
 * Album art resource type.
 */
enum class AlbumArtResourceType constructor(val nameId: Int) {
    /** Built-in image.  */
    INTERNAL(R.string.album_art_resource_internal),
    /** External file lyrics.  */
    EXTERNAL(R.string.album_art_resource_external),
    /** External service image.  */
    SERVICE(R.string.album_art_resource_service),
    /** Content provider image.  */
    PROVIDER(R.string.album_art_resource_provider);

    /** Get the name.  */
    fun getName(context: Context): String {
        return context.getString(nameId)
    }

}
