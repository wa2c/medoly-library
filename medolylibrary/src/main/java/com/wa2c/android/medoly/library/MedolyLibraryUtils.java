package com.wa2c.android.medoly.library;

import android.content.Context;

/**
 * Medoly library utility.
 */
public final class MedolyLibraryUtils {

    /**
     * Get the property from key name.
     * @param keyName A key name.
     * @return The property.
     */
    public static IProperty getKeyProperty(String keyName) {
        IProperty p = MediaProperty.valueOfKey(keyName);
        if (p == null) p = AlbumArtProperty.valueOfKey(keyName);
        if (p == null) p = LyricsProperty.valueOfKey(keyName);
        if (p == null) p = QueueProperty.valueOf(keyName);
        return p;
    }

    /**
     * Get the property type label from property.
     * @param context A context.
     * @param p A property.
     * @return The property type label.
     */
    public static String getPropertyTypeLabel(Context context, IProperty p) {
        if (p instanceof MediaProperty)
            return context.getString(R.string.media);
        else if (p instanceof AlbumArtProperty)
            return context.getString(R.string.album_art);
        else if (p instanceof LyricsProperty)
            return context.getString(R.string.lyrics);
        else if (p instanceof QueueProperty)
            return context.getString(R.string.queue);
        else
            return "";
    }

}
