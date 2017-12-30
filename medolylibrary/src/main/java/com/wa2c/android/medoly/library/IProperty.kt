package com.wa2c.android.medoly.library


import android.content.Context

/**
 * Property interface.
 */
interface IProperty {
    /** Get property name id.  */
    val nameId: Int
    /** Get the property key name.  */
    val keyName: String

    /** Get the property name.  */
    fun getName(context: Context): String
}
