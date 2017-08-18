package com.wa2c.android.medoly.library;


import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Property interface.
 */
public interface IProperty {
    /** Get property name id. */
    int getNameId();
    /** Get the property name. */
    String getName(@NonNull Context context);
    /** Get the property key name. */
    String getKeyName();
}
