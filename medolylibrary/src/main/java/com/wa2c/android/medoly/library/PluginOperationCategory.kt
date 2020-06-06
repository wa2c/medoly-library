package com.wa2c.android.medoly.library

import android.content.Context

/**
 * Plugin operation category.
 */
enum class PluginOperationCategory constructor(val nameId: Int) {
    /** Execute.  */
    OPERATION_EXECUTE(R.string.label_plugin_operation_execute),
    /** App launch. */
    OPERATION_APP_LAUNCH(R.string.label_plugin_operation_app_launch),
    /** Open media.  */
    OPERATION_MEDIA_OPEN(R.string.label_plugin_operation_media_open),
    /** Start playing.  */
    OPERATION_PLAY_START(R.string.label_plugin_operation_play_start),
    /** Stop playing.  */
    OPERATION_PLAY_STOP(R.string.label_plugin_operation_play_stop),
    /** Close media.  */
    OPERATION_MEDIA_CLOSE(R.string.label_plugin_operation_media_close),
    /** App quit. */
    OPERATION_APP_QUIT(R.string.label_plugin_operation_app_quit),
    /** Now playing.  */
    OPERATION_PLAY_NOW(R.string.label_plugin_operation_play_now),
    /** Complete playing.  */
    OPERATION_PLAY_COMPLETE(R.string.label_plugin_operation_play_complete);



    /** Category value.  */
    val categoryValue: String = "com.wa2c.android.medoly.plugin.category." + this.name

    /** Get the category name.  */
    fun getName(context: Context): String {
        return context.getString(nameId)
    }


}
