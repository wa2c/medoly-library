package com.wa2c.android.medoly.library

import android.net.Uri

/**
 * Property data.
 */
open class PropertyData : ExtraData {

    /**
     * Constructor.
     */
    constructor() : super()

    /**
     * Constructor.
     * @param capacity The capacity.
     */
    constructor(capacity: Int) : super(capacity)

    /**
     * Copy constructor.
     * @param propertyData A property data.
     */
    constructor(propertyData: Map<String, MutableList<String?>?>) : super(propertyData)

    /**
     * Copy constructor.
     * @param propertyData A property data.
     */
    constructor(propertyData: PropertyData) : super(propertyData)


    /**
     * Returns true if this map contains a mapping for the specified key.
     * @param key A property key.
     * @return true if this map contains a mapping for the specified key.
     */
    fun containsKey(key: IProperty?): Boolean {
        return super.containsKey(key?.keyName)
    }

    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings.
     */
    fun isEmpty(key: IProperty?): Boolean {
        return this.isEmpty(key?.keyName)
    }

    /**
     * Get property value list.
     * @param key A property key.
     * @return The property value list.
     */
    operator fun get(key: IProperty?): MutableList<String?>? {
        return super.get(key?.keyName)
    }

    /**
     * Get the first property value.
     * @param key A property key.
     * @return The first property value.
     */
    fun getFirst(key: IProperty?): String? {
        return super.getFirst(key?.keyName)
    }

    /**
     * Get the values concatenated by line breaks as text.
     * @param key A property key.
     * @return The concatenated property text.
     */
    fun getText(key: IProperty?): String {
        return super.getText(key?.keyName, "\n")
     }

    /**
     * Get the values concatenated by separator as text.
     * @param key A property key.
     * @param separator A separator.
     * @return The concatenated property text.
     */
    fun getText(key: IProperty?, separator: String?): String {
        return super.getText(key?.keyName, separator)
    }

    /**
     * Set the new property value list. (indexed access operator)
     * @param key A property key.
     * @param value The property value.
     */
    operator fun set(key: IProperty?, value: MutableList<String?>?): MutableList<String?>? {
        return put(key, value)
    }

    /**
     * Set the new property value list. (indexed access operator)
     * @param key A property key.
     * @param value The property value.
     */
    operator fun set(key: IProperty?, value: String?): MutableList<String?>? {
        return put(key, value)
    }

    /**
     * Put the new property value list.
     * @param key A property key.
     * @param value The property value list.
     */
    fun put(key: IProperty?, value: MutableList<String?>?): MutableList<String?>? {
        return  super.put(key?.keyName, value)
    }

    /**
     * Put the new property value.
     * @param key A property key.
     * @param value The property value.
     */
    fun put(key: IProperty?, value: String?): MutableList<String?>? {
        return super.put(key?.keyName, value)
    }

    /**
     * Insert the property value to first position.
     * @param key A property key.
     * @param value The property value.
     */
    fun insertFirst(key: IProperty?, value: String?) {
        return super.insertFirst(key?.keyName, value)
    }

    /**
     * Insert the property value to last position.
     * @param key A property key.
     * @param value The property value.
     */
    fun insertLast(key: IProperty?, value: String?) {
        return super.insertLast(key?.keyName, value)
    }

    /**
     * Removes the mapping for a key from this map if it is present (optional operation).
     * @param key key whose mapping is to be removed from the map.
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    fun remove(key: IProperty?): MutableList<String?>? {
        return super.remove(key?.keyName)
    }


    /**
     * Compares the specified object with this map for equality.
     * @param property A property key.
     * @param list A property value list.
     * @return true if the specified object is equal to this map.
     */
    fun equals(property: IProperty?, list: MutableList<String?>?): Boolean {
        return super.equals(property?.keyName, list)
    }



    /**
     * Get the media URI.
     * @return The media URI.
     */
    val mediaUri: Uri?
        get() {
            val url = this.getFirst(MediaProperty.DATA_URI)
            if (url.isNullOrEmpty())
                return null
            return try {
                Uri.parse(url)
            } catch (ignore: Exception) {
                null
            }

        }

    /**
     * Get the album art URI.
     * @return The album art URI.
     */
    val albumArtUri: Uri?
        get() {
            val url = this.getFirst(AlbumArtProperty.DATA_URI)
            if (url.isNullOrEmpty())
                return null
            return try {
                Uri.parse(url)
            } catch (ignore: Exception) {
                null
            }

        }

    /**
     * Get the lyrics URI.
     * @return The lyrics URI.
     */
    val lyricsUri: Uri?
        get() {
            val url = this.getFirst(LyricsProperty.DATA_URI)
            if (url.isNullOrEmpty())
                return null
            return try {
                Uri.parse(url)
            } catch (ignore: Exception) {
                null
            }

        }

    /**
     * Returns true if this property has media data.
     * @return true if this map has no media data.
     */
    val isMediaEmpty: Boolean
        get() = this.getFirst(MediaProperty.DATA_URI).isNullOrEmpty()

    /**
     * Returns true if this property has album art data.
     * @return true if this map has no album art data.
     */
    val isAlbumArtEmpty: Boolean
        get() = this.getFirst(AlbumArtProperty.RESOURCE_TYPE).isNullOrEmpty()

    /**
     * Returns true if this property has lyrics data.
     * @return true if this map has no lyrics data.
     */
    val isLyricsEmpty: Boolean
        get() = this.getFirst(LyricsProperty.RESOURCE_TYPE).isNullOrEmpty()

    companion object {
        val EMPTY = PropertyData()
    }

}
