package com.wa2c.android.medoly.library


import android.content.Context
import android.os.Parcelable

/**
 * Property interface.
 */
interface IProperty : Parcelable {
    /** Get property name id.  */
    val nameId: Int
    /** Get the property key name.  */
    val keyName: String

    /** Get the property name.  */
    fun getName(context: Context): String
}
