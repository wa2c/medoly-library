package com.wa2c.android.medoly.library

import android.content.Intent

/**
 * Media action plugin intent.
 */
@Suppress("UNCHECKED_CAST")
class MediaPluginIntent : Intent {

    /**
     * Constructor.
     */
    constructor() : super(PluginAction.ACTION_MEDIA.actionValue)

    /**
     * Constructor.
     * @param intent A intent.
     */
    constructor(intent: Intent) : super(intent)



    /**
     * A property data.
     */
    var propertyData: PropertyData?
        get() {
            val keyArray = this.getStringArrayExtra(PLUGIN_PROPERTY_KEY_ARRAY)
            val valueArray = this.getSerializableExtra(PLUGIN_PROPERTY_VALUE_ARRAY) as Array<Any?>?
            if (keyArray == null || valueArray == null || keyArray.size != valueArray.size)
                return null
            val data = PropertyData(keyArray.size)
            for (i in keyArray.indices) {
                data[keyArray[i]] = valueArray[i] as MutableList<String?>?
            }
            return data
        }
        set(data) {
            this.putExtra(PLUGIN_PROPERTY_KEY_ARRAY, data?.keys?.toTypedArray())
            this.putExtra(PLUGIN_PROPERTY_VALUE_ARRAY, data?.values?.toTypedArray())
        }

    /**
     * A extra data.
     */
    var extraData: ExtraData?
        get() {
            val keyArray = this.getStringArrayExtra(PLUGIN_EXTRA_KEY_ARRAY)
            val valueArray = this.getSerializableExtra(PLUGIN_EXTRA_VALUE_ARRAY) as Array<Any?>?
            if (keyArray == null || valueArray == null || keyArray.size != valueArray.size)
                return null
            val data = ExtraData(keyArray.size)
            for (i in keyArray.indices) {
                data[keyArray[i]] = valueArray[i] as MutableList<String?>?
            }
            return data
        }
        set(extraData) {
            this.putExtra(PLUGIN_EXTRA_KEY_ARRAY, extraData?.keys?.toTypedArray())
            this.putExtra(PLUGIN_EXTRA_VALUE_ARRAY, extraData?.values?.toTypedArray())
        }

    /**
     * A action ID.
     */
    var actionId: String?
        get() = this.getStringExtra(PLUGIN_ACTION_ID)
        set(actionId) {
            this.putExtra(PLUGIN_ACTION_ID, actionId)
        }

    /**
     * A action label;
     */
    var actionLabel: String?
        get() = this.getStringExtra(PLUGIN_ACTION_LABEL)
        set(label) {
            this.putExtra(PLUGIN_ACTION_LABEL, label)
        }

    /**
     * A action priority.
     */
    var actionPriority: Int?
        get() = this.getIntExtra(PLUGIN_ACTION_PRIORITY, -1)
        set(priority) {
            this.putExtra(PLUGIN_ACTION_PRIORITY, priority)
        }

    /**
     * Check if the intent sent automatically.
     */
    var isAutomatically: Boolean
        get() = this.getBooleanExtra(PLUGIN_IS_AUTOMATICALLY, false)
        set(isAutomatically) {
            this.putExtra(PLUGIN_IS_AUTOMATICALLY, isAutomatically)
        }



    /**
     * A source package name.
     */
    var srcPackage: String?
        get() = this.getStringExtra(PLUGIN_SRC_PACKAGE)
        set(srcPackage) {
            this.putExtra(PLUGIN_SRC_PACKAGE, srcPackage)
        }

    /**
     * A source class name.
     */
    var srcClass: String?
        get() = this.getStringExtra(PLUGIN_SRC_CLASS)
        set(srcClass) {
            this.putExtra(PLUGIN_SRC_CLASS, srcClass)
        }



    /**
     * Add the plugin operation category.
     * @param category The plugin operation category.
     */
    fun addCategory(category: PluginOperationCategory?): Intent {
        return if (category != null)
            this.addCategory(category.categoryValue)
        else
            this
    }

    /**
     * Add the plugin type category.
     * @param category The plugin type category.
     */
    fun addCategory(category: PluginTypeCategory?): Intent {
        return if (category != null)
            this.addCategory(category.categoryValue)
        else
            this
    }

    /**
     * Check if the plugin operation category exists.
     * @param category A plugin operation category.
     * @return True if the category exits.
     */
    fun hasCategory(category: PluginOperationCategory?): Boolean {
        return if (category != null)
            this.hasCategory(category.categoryValue)
        else
            false
    }

    /**
     * Check if the plugin type category exists.
     * @param category Plugin type category.
     * @return True if the category exits.
     */
    fun hasCategory(category: PluginTypeCategory?): Boolean {
        return if (category != null)
            this.hasCategory(category.categoryValue)
        else
            false
    }



    /**
     * Create a response intent.
     * @param propertyData Property data. Not set if null.
     * @param extraData Extra data. Not set if null.
     * @return A response intent.
     */
    @JvmOverloads
    fun createResultIntent(propertyData: PropertyData? = null, extraData: ExtraData? = null): MediaPluginIntent {
        val returnIntent = MediaPluginIntent()
        if (srcClass != null && srcClass != null)
            returnIntent.setClassName(srcPackage!!, srcClass!!)
        else if (srcPackage != null)
            returnIntent.`package` = srcPackage
        if (propertyData != null)
            returnIntent.propertyData = propertyData
        if (extraData != null)
            returnIntent.extraData = extraData
        returnIntent.actionId = actionId
        returnIntent.actionLabel = actionLabel
        returnIntent.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_GRANT_READ_URI_PERMISSION or FLAG_GRANT_WRITE_URI_PERMISSION
        return returnIntent
    }



    companion object {

        /** Action ID key.  */
        private const val PLUGIN_ACTION_ID = "action_id"
        /** Action label key.  */
        private const val PLUGIN_ACTION_LABEL = "action_label"
        /** Action priority.  */
        private const val PLUGIN_ACTION_PRIORITY = "action_priority"
        /** Is automatically.  */
        private const val PLUGIN_IS_AUTOMATICALLY = "is_automatically"
        /** Source package name.  */
        private const val PLUGIN_SRC_PACKAGE = "src_package"
        /** Source class name.  */
        private const val PLUGIN_SRC_CLASS = "src_class"

        /** Property key array key.  */
        private const val PLUGIN_PROPERTY_KEY_ARRAY = "property_key_array"
        /** Property value array key.  */
        private const val PLUGIN_PROPERTY_VALUE_ARRAY = "property_value_array"
        /** Extra key array key.  */
        private const val PLUGIN_EXTRA_KEY_ARRAY = "extra_key_array"
        /** Extra value array key.  */
        private const val PLUGIN_EXTRA_VALUE_ARRAY = "extra_value_array"
    }

}
