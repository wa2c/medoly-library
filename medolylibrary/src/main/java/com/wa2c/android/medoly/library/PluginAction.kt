package com.wa2c.android.medoly.library

/**
 * Plugin action.
 */
enum class PluginAction {
    /** Media action plugin.  */
    ACTION_MEDIA,
    /** Search action plugin.  */
    ACTION_SEARCH;



    /** Action value.  */
    val actionValue: String = "com.wa2c.android.medoly.plugin.action." + this.name
}
