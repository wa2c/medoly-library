package com.wa2c.android.medoly.library;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Plugin operation category.
 */
public enum PluginOperationCategory {
    /** Execute. */
    OPERATION_EXECUTE       (R.string.label_plugin_operation_execute),
    /** Open media. */
    OPERATION_MEDIA_OPEN    (R.string.label_plugin_operation_media_open),
    /** Start playing. */
    OPERATION_PLAY_START    (R.string.label_plugin_operation_play_start),
    /** Stop playing. */
    OPERATION_PLAY_STOP     (R.string.label_plugin_operation_play_stop),
    /** Close media. */
    OPERATION_MEDIA_CLOSE   (R.string.label_plugin_operation_media_close),
    /** Now playing. */
    OPERATION_PLAY_NOW      (R.string.label_plugin_operation_play_now),
    /** Complete playing. */
    OPERATION_PLAY_COMPLETE (R.string.label_plugin_operation_play_complete);



    /** Constructor. */
    PluginOperationCategory(int nameId) {
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
