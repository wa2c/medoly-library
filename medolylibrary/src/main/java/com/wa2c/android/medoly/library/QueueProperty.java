package com.wa2c.android.medoly.library;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Play queue property.
 */
public enum QueueProperty implements IProperty {
    /** Current media position, */
    CURRENT_POSITION ( R.string.queue_current_position ),
    /** Current queue no, */
    CURRENT_NO       ( R.string.queue_current_no       ),
    /** Current queue total. */
    TOTAL_COUNT      ( R.string.queue_total_count      ),
    /** Current played queue total count. */
    PLAYED_COUNT     ( R.string.queue_played_count     ),
    /** Current queue total time. */
    TOTAL_TIME       ( R.string.queue_total_time       ),
    /** Current played queue total time. */
    PLAYED_TIME      ( R.string.queue_played_time      ),
    /** Current media loop count. */
    LOOP_COUNT       ( R.string.queue_loop_count       );



    /** Constructor. */
    QueueProperty(int nameId) {
        this.nameId = nameId;
        this.keyName = KEY_PREFIX + "_" + this.name();
    }

    /** Name id */
    private int nameId;
    /** Property key name */
    private String keyName;

    /** Get the property name id. */
    public int getNameId() {
        return this.nameId;
    }
    /** Get the property name. */
    public String getName(@NonNull Context context) {
        return context.getString(nameId);
    }
    /** Get the property key name. */
    public String getKeyName() {
        return keyName;
    }

    // static

    /** Prefix to property key name. */
    public static final String KEY_PREFIX = "QUEUE";

    /**
     * Map of a key name and a property.
     */
    private static final Map<String, QueueProperty> keyPropertyMap = new HashMap<String, QueueProperty>() {{
        for (QueueProperty p : QueueProperty.values()) {
            put(p.getKeyName(), p);
        }
    }};

    /**
     * Get the property from a key name.
     * @param keyName A key name.
     * @return The property.
     */
    public static QueueProperty valueOfKey(String keyName) {
        return keyPropertyMap.get(keyName);
    }

}