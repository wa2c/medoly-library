package com.wa2c.android.medoly.library;

/**
 * Plugin action.
 */
public enum PluginAction {
    /** Media action plugin. */
    ACTION_MEDIA,
    /** Search action plugin. */
    ACTION_SEARCH;



    /** Constructor. */
    PluginAction() {
        actionValue = "com.wa2c.android.medoly.plugin.action." + this.name();
    }

    /** Action value. */
    private String actionValue;
    /** Get the action value. */
    public String getActionValue() {
        return actionValue;
    }

}
