package com.wa2c.android.medoly.library;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Album art properties.
 */
public enum AlbumArtProperty implements IProperty {
    /** Resource type. */
    RESOURCE_TYPE ( R.string.album_art_resource_type ),
    /** Picture type. */
    PICTURE_TYPE  ( R.string.album_art_picture_type  ),
    /** Image size. */
    IMAGE_SIZE    ( R.string.album_art_resolution    ),

    /** Description. */
    DESCRIPTION   ( R.string.description             ),
    /** MIME Type. */
    MIME_TYPE     ( R.string.mime_type               ),
    /** Folder path. */
    FOLDER_PATH   ( R.string.folder_path             ),
    /** File name. */
    FILE_NAME     ( R.string.file_name               ),
    /** Data size. */
    DATA_SIZE     ( R.string.data_size               ),
    /** Last modified date. */
    LAST_MODIFIED ( R.string.last_modified           ),
    /** URI. */
    DATA_URI      ( R.string.data_uri                ),

    /** Source name. */
    SOURCE_TITLE  ( R.string.source_title            ),
    /** Source URI. */
    SOURCE_URI    ( R.string.source_uri              );



    /** Constructor. */
    AlbumArtProperty(int nameId) {
        this.nameId = nameId;
        this.keyName = KEY_PREFIX + "_" + this.name();
    }

    /** Name id */
    private int nameId;
    /** Property key name */
    private String keyName;

    /** Get the property name id. */
    public int getNameId() {
        return this.nameId;
    }
    /** Get the property name. */
    public String getName(@NonNull Context context) {
        return context.getString(nameId);
    }
    /** Get the property key name. */
    public String getKeyName() {
        return keyName;
    }

    // static

    /** Prefix to property key name. */
    public static final String KEY_PREFIX = "ALBUM_ART";

    /**
     * Map of a key name and a property.
     */
    private static final Map<String, AlbumArtProperty> keyPropertyMap = new HashMap<String, AlbumArtProperty>() {{
        for (AlbumArtProperty p : AlbumArtProperty.values()) {
            put(p.getKeyName(), p);
        }
    }};

    /**
     * Get the property from a key name.
     * @param keyName A key name.
     * @return The property.
     */
    public static AlbumArtProperty valueOfKey(String keyName) {
        return keyPropertyMap.get(keyName);
    }

}
