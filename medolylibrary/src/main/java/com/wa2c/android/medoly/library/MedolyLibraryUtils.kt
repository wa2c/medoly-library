package com.wa2c.android.medoly.library

import android.content.Context

/**
 * Medoly library utility.
 */
object MedolyLibraryUtils {

    /**
     * Get the property from key name.
     * @param keyName A key name.
     * @return The property.
     */
    fun getKeyProperty(keyName: String): IProperty? {
        var p: IProperty? = MediaProperty.valueOfKey(keyName)
        if (p == null) p = AlbumArtProperty.valueOfKey(keyName)
        if (p == null) p = LyricsProperty.valueOfKey(keyName)
        if (p == null) p = QueueProperty.valueOfKey(keyName)
        return p
    }

    /**
     * Get the property type label from property.
     * @param context A context.
     * @param p A property.
     * @return The property type label.
     */
    fun getPropertyTypeLabel(context: Context, p: IProperty): String {
        return when (p) {
            is MediaProperty -> context.getString(R.string.media)
            is AlbumArtProperty -> context.getString(R.string.album_art)
            is LyricsProperty -> context.getString(R.string.lyrics)
            is QueueProperty -> context.getString(R.string.queue)
            else -> ""
        }
    }

}
