package com.wa2c.android.medoly.library;

import android.content.Intent;

import java.util.List;

/**
 * Media action plugin intent.
 */
public class MediaPluginIntent extends Intent {

    /** Action ID key. */
    private static final String PLUGIN_ACTION_ID = "action_id";
    /** Action label key. */
    private static final String PLUGIN_ACTION_LABEL = "action_label";
    /** Action priority. */
    private static final String PLUGIN_ACTION_PRIORITY = "action_priority";
    /** Is automatically. */
    private static final String PLUGIN_IS_AUTOMATICALLY = "is_automatically";
    /** Source package name. */
    private static final String PLUGIN_SRC_PACKAGE = "src_package";
    /** Source class name. */
    private static final String PLUGIN_SRC_CLASS = "src_class";

    /** Property key array key. */
    private static final String PLUGIN_PROPERTY_KEY_ARRAY  = "property_key_array";
    /** Property value array key. */
    private static final String PLUGIN_PROPERTY_VALUE_ARRAY  = "property_value_array";
    /** Extra key array key. */
    private static final String PLUGIN_EXTRA_KEY_ARRAY  = "extra_key_array";
    /** Extra value array key. */
    private static final String PLUGIN_EXTRA_VALUE_ARRAY  = "extra_value_array";



    /**
     * Constructor.
     */
    public MediaPluginIntent() {
        super(PluginAction.ACTION_MEDIA.getActionValue());
    }

    /**
     * Constructor.
     * @param intent A intent.
     */
    public MediaPluginIntent(Intent intent) {
        super(intent);
    }

    /**
     * Get the property data.
     * @return A property data.
     */
    public PropertyData getPropertyData() {
        String[] keyArray = this.getStringArrayExtra(PLUGIN_PROPERTY_KEY_ARRAY);
        Object[] valueArray = (Object[])this.getSerializableExtra(PLUGIN_PROPERTY_VALUE_ARRAY);
        if (keyArray == null || valueArray == null || keyArray.length != valueArray.length)
            return null;
        PropertyData data = new PropertyData(keyArray.length);
        for (int i = 0; i < keyArray.length; i++) {
            data.put(keyArray[i], (List<String>)valueArray[i]);
        }
        return data;
    }

    /**
     * Set the property data.
     * @param propertyData A property data.
     */
    public void setPropertyData(PropertyData propertyData) {
        this.putExtra(PLUGIN_PROPERTY_KEY_ARRAY, propertyData.keySet().toArray(new String[propertyData.size()]));
        this.putExtra(PLUGIN_PROPERTY_VALUE_ARRAY, propertyData.values().toArray(new List[propertyData.size()]));
    }

    /**
     * Get the extra data.
     * @return The extra data.
     */
    public ExtraData getExtraData() {
        String[] keyArray = this.getStringArrayExtra(PLUGIN_EXTRA_KEY_ARRAY);
        Object[] valueArray = (Object[])this.getSerializableExtra(PLUGIN_EXTRA_VALUE_ARRAY);
        if (keyArray == null || valueArray == null || keyArray.length != valueArray.length)
            return null;
        ExtraData data = new ExtraData(keyArray.length);
        for (int i = 0; i < keyArray.length; i++) {
            data.put(keyArray[i], (List<String>)valueArray[i]);
        }
        return data;
    }

    /**
     * Set the extra data.
     * @param extraData A extra data.
     */
    public void setExtraData(ExtraData extraData) {
        this.putExtra(PLUGIN_EXTRA_KEY_ARRAY, extraData.keySet().toArray(new String[extraData.size()]));
        this.putExtra(PLUGIN_EXTRA_VALUE_ARRAY, extraData.values().toArray(new List[extraData.size()]));
    }


    /**
     * Get the action ID.
     * @return The action ID.
     */
    public String getActionId() {
        return this.getStringExtra(PLUGIN_ACTION_ID);
    }

    /**
     * Set the action ID.
     * @param actionId A action ID.
     */
    public void setActionId(String actionId) {
        this.putExtra(PLUGIN_ACTION_ID, actionId);
    }

    /**
     * Get the action label.
     * @return The action label.
     */
    public String getActionLabel() {
        return this.getStringExtra(PLUGIN_ACTION_LABEL);
    }

    /**
     * Set the action label;
     * @param label The action label.
     */
    public void setActionLabel(String label) {
        this.putExtra(PLUGIN_ACTION_LABEL, label);
    }

    /**
     * Get the action priority.
     * @return The action priority.
     */
    public int getActionPriority() {
        return this.getIntExtra(PLUGIN_ACTION_PRIORITY, -1);
    }

    /**
     * Set the action priority.
     * @param priority The action priority.
     */
    public void setActionPriority(Integer priority) {
        this.putExtra(PLUGIN_ACTION_PRIORITY, priority);
    }

    /**
     * Check if the intent sent automatically.
     * @return True if the intent sent automatically.
     */
    public boolean isAutomatically() {
        return this.getBooleanExtra(PLUGIN_IS_AUTOMATICALLY, false);
    }

    /**
     * Set if the intent sent automatically.
     * @param isAutomatically True if the intent sent automatically.
     */
    public void setAutomatically(boolean isAutomatically) {
        this.putExtra(PLUGIN_IS_AUTOMATICALLY, isAutomatically);
    }


    /**
     * Add the plugin operation category.
     * @param category The plugin operation category.
     */
    public Intent addCategory(PluginOperationCategory category) {
        return this.addCategory(category.getCategoryValue());
    }

    /**
     * Add the plugin type category.
     * @param category The plugin type category.
     */
    public Intent addCategory(PluginTypeCategory category) {
        return this.addCategory(category.getCategoryValue());
    }

    /**
     * Check if the plugin operation category exists.
     * @param category A plugin operation category.
     * @return True if the category exits.
     */
    public boolean hasCategory(PluginOperationCategory category) {
        return this.hasCategory(category.getCategoryValue());
    }

    /**
     * Check if the plugin type category exists.
     * @param category Plugin type category.
     * @return True if the category exits.
     */
    public boolean hasCategory(PluginTypeCategory category) {
        return this.hasCategory(category.getCategoryValue());
    }



    /**
     * Get the source package name.
     * @return The source package name.
     */
    public String getSrcPackage() {
        return this.getStringExtra(PLUGIN_SRC_PACKAGE);
    }

    /**
     * Set the source package name.
     * @param srcPackage The source package name.
     */
    public void setSrcPackage(String srcPackage) {
        this.putExtra(PLUGIN_SRC_PACKAGE, srcPackage);
    }

    /**
     * Get the source class name.
     * @return The source class name.
     */
    public String getSrcClass() {
        return this.getStringExtra(PLUGIN_SRC_CLASS);
    }

    /**
     * Set the source class name.
     * @param srcClass The source class name.
     */
    public void setSrcClass(String srcClass) {
        this.putExtra(PLUGIN_SRC_CLASS, srcClass);
    }

    /**
     * Create a response intent.
     * @param propertyData Property data. Not set if null.
     * @return A response intent.
     */
    public MediaPluginIntent createResultIntent(PropertyData propertyData) {
        return createResultIntent(propertyData, null);
    }

    /**
     * Create a response intent.
     * @param propertyData Property data. Not set if null.
     * @param extraData Extra data. Not set if null.
     * @return A response intent.
     */
    public MediaPluginIntent createResultIntent(PropertyData propertyData, ExtraData extraData) {
        MediaPluginIntent returnIntent = new MediaPluginIntent();
        if (getSrcClass() != null && getSrcClass() != null)
            returnIntent.setClassName(getSrcPackage(), getSrcClass());
        else if (getSrcPackage() != null)
            returnIntent.setPackage(getSrcPackage());
        if (propertyData != null)
            returnIntent.setPropertyData(propertyData);
        if (extraData != null)
            returnIntent.setExtraData(extraData);
        returnIntent.setActionId(getActionId());
        returnIntent.setActionLabel(getActionLabel());
        returnIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        return returnIntent;
    }

}
