package com.wa2c.android.medoly.library

import android.content.Context
import java.util.*

/**
 * Album art properties.
 */
enum class AlbumArtProperty (override val nameId: Int) : IProperty {

    /** Resource type.  */
    RESOURCE_TYPE(R.string.album_art_resource_type),
    /** Picture type.  */
    PICTURE_TYPE(R.string.album_art_picture_type),
    /** Image size.  */
    IMAGE_SIZE(R.string.album_art_resolution),

    /** Description.  */
    DESCRIPTION(R.string.description),
    /** MIME Type.  */
    MIME_TYPE(R.string.mime_type),
    /** Folder path.  */
    FOLDER_PATH(R.string.folder_path),
    /** File base name. */
    FILE_NAME_BASE(R.string.file_name_base),
    /** File name extension. */
    FILE_NAME_EXT(R.string.file_name_ext),
    /** File name.  */
    FILE_NAME(R.string.file_name),
    /** Data size.  */
    DATA_SIZE(R.string.data_size),
    /** Last modified date.  */
    LAST_MODIFIED(R.string.last_modified),
    /** URI.  */
    DATA_URI(R.string.data_uri),

    /** Source name.  */
    SOURCE_TITLE(R.string.source_title),
    /** Source URI.  */
    SOURCE_URI(R.string.source_uri);



    /** Get the property key name.  */
    override val keyName: String
        get()  = KEY_PREFIX + "_" + this.name

    /** Get the property name.  */
    override fun getName(context: Context): String {
        return context.getString(nameId)
    }

    companion object {
        /** Prefix to property key name.  */
        const val KEY_PREFIX = "ALBUM_ART"

        /**
         * Map of a key name and a property.
         */
        private val keyPropertyMap = object : HashMap<String, AlbumArtProperty>() {
            init {
                for (p in AlbumArtProperty.values()) {
                    put(p.keyName, p)
                }
            }
        }

        /**
         * Get the property from a key name.
         * @param keyName A key name.
         * @return The property.
         */
        fun valueOfKey(keyName: String): AlbumArtProperty? {
            return keyPropertyMap[keyName]
        }
    }

}
