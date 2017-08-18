package com.wa2c.android.medoly.library;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Plugin type category.
 */
public enum PluginTypeCategory {
    /** Run plugin. */
    TYPE_RUN           (R.string.label_plugin_type_run),
    /** Post message plugin. */
    TYPE_POST_MESSAGE  (R.string.label_plugin_type_post_message),
    /** Get property plugin */
    TYPE_GET_PROPERTY  (R.string.label_plugin_type_get_property),
    /** Get album art plugin. */
    TYPE_GET_ALBUM_ART (R.string.label_plugin_type_get_album_art),
    /** Get lyrics plugin. */
    TYPE_GET_LYRICS    (R.string.label_plugin_type_get_lyrics);



    /** Constructor. */
    PluginTypeCategory(int nameId) {
        this.nameId = nameId;
        this.categoryValue = "com.wa2c.android.medoly.plugin.category." + this.name();
    }

    /** Name id */
    private int nameId;
    /** Category value. */
    private String categoryValue;

    /** Get the category name id. */
    public int getNameId() {
        return this.nameId;
    }
    /** Get the category name. */
    public String getName(@NonNull Context context) {
        return context.getString(nameId);
    }
    /** Get the category value. */
    public String getCategoryValue() {
        return categoryValue;
    }

}
