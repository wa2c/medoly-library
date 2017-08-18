package com.wa2c.android.medoly.library;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Lyrics resource type.
 */
public enum LyricsResourceType {
    /** Built-in lyrics. */
    INTERNAL(R.string.lyrics_resource_internal),
    /** External file lyrics. */
    EXTERNAL(R.string.lyrics_resource_file),
    /** External service lyrics. */
    SERVICE(R.string.lyrics_resource_service);



    /** Constructor. */
    LyricsResourceType(int id) {
        this.nameId = id;
    }

    /** Name id. */
    private int nameId;

    /** Get the name id. */
    public int getNameId() {
        return nameId;
    }
    /** Get the name. */
    public String getName(@NonNull Context context) {
        return context.getString(nameId);
    }

}