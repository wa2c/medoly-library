package com.wa2c.android.medoly.library

import android.content.Context

/**
 * Plugin type category.
 */
enum class PluginTypeCategory constructor(val nameId: Int) {
    /** Run plugin.  */
    TYPE_RUN(R.string.label_plugin_type_run),
    /** Post message plugin.  */
    TYPE_POST_MESSAGE(R.string.label_plugin_type_post_message),
    /** Get property plugin  */
    TYPE_GET_PROPERTY(R.string.label_plugin_type_get_property),
    /** Get album art plugin.  */
    TYPE_GET_ALBUM_ART(R.string.label_plugin_type_get_album_art),
    /** Get lyrics plugin.  */
    TYPE_GET_LYRICS(R.string.label_plugin_type_get_lyrics);



    /** Category value.  */
    val categoryValue: String = "com.wa2c.android.medoly.plugin.category." + this.name

    /** Get the category name.  */
    fun getName(context: Context): String {
        return context.getString(nameId)
    }

}
