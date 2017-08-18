package com.wa2c.android.medoly.library;

import android.net.Uri;
import android.text.TextUtils;

import java.util.List;
import java.util.Map;

/**
 * Property data.
 */
public class PropertyData extends ExtraData {

    /**
     * Constructor.
     */
    public PropertyData() {
        super();
    }

    /**
     * Constructor.
     * @param capacity The capacity.
     */
    public PropertyData(int capacity) {
        super(capacity);
    }

    /**
     * Copy constructor.
     * @param propertyData A property data.
     */
    public PropertyData(Map<String, List<String>> propertyData) {
        super(propertyData);
    }



    /**
     * Returns true if this map contains a mapping for the specified key.
     * @param key A property key.
     * @return true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(IProperty key) {
        return super.containsKey(key.getKeyName());
    }

    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings.
     */
    public boolean isEmpty(IProperty key) {
        return this.isEmpty(key.getKeyName());
    }



    /**
     * Get property value list.
     * @param key A property key.
     * @return The property value list.
     */
    public List<String> get(IProperty key) {
        return super.get(key.getKeyName());
    }

    /**
     * Get the first property value.
     * @param key A property key.
     * @return The first property value.
     */
    public String getFirst(IProperty key) {
        return this.getFirst(key.getKeyName());
    }

    /**
     * Get the values concatenated by line breaks as text.
     * @param key A property key.
     * @return The concatenated property text.
     */
    public String getText(IProperty key) {
        return getText(key.getKeyName(), "\n");
    }

    /**
     * Get the values concatenated by separator as text.
     * @param key A property key.
     * @param separator A separator.
     * @return The concatenated property text.
     */
    public String getText(IProperty key, String separator) {
        return getText(key.getKeyName(), separator);
    }



    /**
     * Put the new property value list.
     * @param key A property key.
     * @param value The property value list.
     */
    public List<String> put(IProperty key, List<String> value) {
        return super.put(key.getKeyName(), value);
    }

    /**
     * Put the new property value.
     * @param key A property key.
     * @param value The property value.
     */
    public List<String>  put(IProperty key, String value) {
        return this.put(key.getKeyName(), value);
    }

    /**
     * Insert the property value to first position.
     * @param key A property key.
     * @param value The property value.
     */
    public void insertFirst(IProperty key, String value) {
        this.insertFirst(key.getKeyName(), value);
    }

    /**
     * Insert the property value to last position.
     * @param key A property key.
     * @param value The property value.
     */
    public void insertLast(IProperty key, String value) {
        this.insertLast(key.getKeyName(), value);
    }

    /**
     * Removes the mapping for a key from this map if it is present (optional operation).
     * @param key key whose mapping is to be removed from the map.
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    public List<String> remove(IProperty key) {
        return super.remove(key.getKeyName());
    }



    /**
     * Get the media URI.
     * @return The media URI.
     */
    public Uri getMediaUri() {
        String url=  this.getFirst(MediaProperty.DATA_URI);
        if (TextUtils.isEmpty(url))
            return null;
        try { return Uri.parse(url); }
        catch (Exception e) { return null; }
    }

    /**
     * Get the album art URI.
     * @return The album art URI.
     */
    public Uri getAlbumArtUri() {
        String url=  this.getFirst(AlbumArtProperty.DATA_URI);
        if (TextUtils.isEmpty(url))
            return null;
        try { return Uri.parse(url); }
        catch (Exception e) { return null; }
    }

    /**
     * Get the lyrics URI.
     * @return The lyrics URI.
     */
    public Uri getLyricsUri() {
        String url=  this.getFirst(LyricsProperty.DATA_URI);
        if (TextUtils.isEmpty(url))
            return null;
        try { return Uri.parse(url); }
        catch (Exception e) { return null; }
    }

    /**
     * Returns true if this property has media data.
     * @return true if this map has no media data.
     */
    public boolean isMediaEmpty() {
        return TextUtils.isEmpty(this.getFirst(MediaProperty.DATA_URI));
    }

    /**
     * Returns true if this property has album art data.
     * @return true if this map has no album art data.
     */
    public boolean isAlbumArtEmpty() {
        return TextUtils.isEmpty(this.getFirst(AlbumArtProperty.RESOURCE_TYPE));
    }

    /**
     * Returns true if this property has lyrics data.
     * @return true if this map has no lyrics data.
     */
    public boolean isLyricsEmpty() {
        return TextUtils.isEmpty(this.getFirst(LyricsProperty.RESOURCE_TYPE));
    }



    /**
     * Compares the specified object with this map for equality.
     * @param property A property key.
     * @param list A property value list.
     * @return true if the specified object is equal to this map.
     */
    public boolean equals(IProperty property, List<String> list) {
        return this.equals(property.getKeyName(), list);
    }

}
