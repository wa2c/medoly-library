package com.wa2c.android.medoly.library

import android.content.Context
import java.util.*

/**
 * Lyrics properties.
 */
enum class LyricsProperty constructor(override val nameId: Int) : IProperty {
    /** Lyrics.  */
    LYRICS(R.string.lyrics_lyrics),

    /** Resource type.  */
    RESOURCE_TYPE(R.string.lyrics_resource_type),
    /** Format type.  */
    FORMAT_TYPE(R.string.lyrics_format_type),
    /** Field name.  */
    FIELD_NAME(R.string.lyrics_field_name),
    /** Synchronous type.  */
    SYNC_TYPE(R.string.lyrics_sync_type),
    /** Offset time. (ms)  */
    OFFSET_TIME(R.string.lyrics_offset_time),
    /** Character encoding.  */
    CHARACTER_ENCODING(R.string.lyrics_character_encoding),

    /** Description.  */
    DESCRIPTION(R.string.description),
    /** MIME Type  */
    MIME_TYPE(R.string.mime_type),
    /** Folder path.  */
    FOLDER_PATH(R.string.folder_path),
    /** File name.  */
    FILE_NAME(R.string.file_name),
    /** Data size.  */
    DATA_SIZE(R.string.data_size),
    /** Last modified date.  */
    LAST_MODIFIED(R.string.last_modified),
    /** URI.  */
    DATA_URI(R.string.data_uri),

    /** Source title.  */
    SOURCE_TITLE(R.string.source_title),
    /** Source URI.  */
    SOURCE_URI(R.string.source_uri);



    /** Get the property key name.  */
    override val keyName by lazy { KEY_PREFIX + "_" + this.name }

    /** Get the property name.  */
    override fun getName(context: Context): String {
        return context.getString(nameId)
    }

    companion object {
        /** Prefix to property key name.  */
        val KEY_PREFIX = "LYRICS"

        /**
         * Map of a key name and a property.
         */
        private val keyPropertyMap = object : HashMap<String, LyricsProperty>() {
            init {
                for (p in LyricsProperty.values()) {
                    put(p.keyName, p)
                }
            }
        }

        /**
         * Get the property from a key name.
         * @param keyName A key name.
         * @return The property.
         */
        fun valueOfKey(keyName: String): LyricsProperty? {
            return keyPropertyMap[keyName]
        }
    }

}
