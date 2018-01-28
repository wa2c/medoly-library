package com.wa2c.android.medoly.library

import android.content.Context
import java.util.*

/**
 * Play queue property.
 */
enum class QueueProperty constructor(override val nameId: Int) : IProperty {
    /** Current media position,  */
    CURRENT_POSITION(R.string.queue_current_position),
    /** Current queue no,  */
    CURRENT_NO(R.string.queue_current_no),
    /** Current queue total.  */
    TOTAL_COUNT(R.string.queue_total_count),
    /** Current played queue total count.  */
    PLAYED_COUNT(R.string.queue_played_count),
    /** Current queue total time.  */
    TOTAL_TIME(R.string.queue_total_time),
    /** Current played queue total time.  */
    PLAYED_TIME(R.string.queue_played_time),
    /** Current media loop count.  */
    LOOP_COUNT(R.string.queue_loop_count);



    /** Property key name  */
    override val keyName by lazy { KEY_PREFIX + "_" + this.name }

    /** Get the property name.  */
    override fun getName(context: Context): String {
        return context.getString(nameId)
    }

    companion object {
        /** Prefix to property key name.  */
        val KEY_PREFIX = "QUEUE"

        /**
         * Map of a key name and a property.
         */
        private val keyPropertyMap = object : HashMap<String, QueueProperty>() {
            init {
                for (p in QueueProperty.values()) {
                    put(p.keyName, p)
                }
            }
        }

        /**
         * Get the property from a key name.
         * @param keyName A key name.
         * @return The property.
         */
        fun valueOfKey(keyName: String): QueueProperty? {
            return keyPropertyMap[keyName]
        }
    }

}