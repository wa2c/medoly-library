package com.wa2c.android.medoly.library;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Lyrics properties.
 */
public enum LyricsProperty implements IProperty {
    /** Lyrics. */
    LYRICS             ( R.string.lyrics_lyrics             ),

    /** Resource type. */
    RESOURCE_TYPE      ( R.string.lyrics_resource_type      ),
    /** Format type. */
    FORMAT_TYPE        ( R.string.lyrics_format_type        ),
    /** Field name. */
    FIELD_NAME         ( R.string.lyrics_field_name         ),
    /** Synchronous type. */
    SYNC_TYPE          ( R.string.lyrics_sync_type          ),
    /** Offset time. (ms) */
    OFFSET_TIME        ( R.string.lyrics_offset_time        ),
    /** Character encoding. */
    CHARACTER_ENCODING ( R.string.lyrics_character_encoding ),

    /** Description. */
    DESCRIPTION        ( R.string.description               ),
    /** MIME Type */
    MIME_TYPE          ( R.string.mime_type                 ),
    /** Folder path. */
    FOLDER_PATH        ( R.string.folder_path               ),
    /** File name. */
    FILE_NAME          ( R.string.file_name                 ),
    /** Data size. */
    DATA_SIZE          ( R.string.data_size                 ),
    /** Last modified date. */
    LAST_MODIFIED      ( R.string.last_modified             ),
    /** URI. */
    DATA_URI           ( R.string.data_uri                  ),

    /** Source title. */
    SOURCE_TITLE       ( R.string.source_title              ),
    /** Source URI. */
    SOURCE_URI         ( R.string.source_uri                );



    /** Constructor. */
    LyricsProperty(int nameId) {
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
    public static final String KEY_PREFIX = "LYRICS";

    /**
     * Map of a key name and a property.
     */
    private static final Map<String, LyricsProperty> keyPropertyMap = new HashMap<String, LyricsProperty>() {{
        for (LyricsProperty p : LyricsProperty.values()) {
            put(p.getKeyName(), p);
        }
    }};

    /**
     * Get the property from a key name.
     * @param keyName A key name.
     * @return The property.
     */
    public static LyricsProperty valueOfKey(String keyName) {
        return keyPropertyMap.get(keyName);
    }

}
