package com.wa2c.android.medoly.library

/**
 * Plugin broadcast result.
 */
enum class PluginBroadcastResult constructor(val resultCode: Int) {
    /** Request process completed. */
    COMPLETE(3),
    /** Request processing. */
    PROCESSING(2),
    /** Request ignored.  */
    IGNORE(1),
    /** Request process canceled. (= Activity.RESULT_CANCEL)  */
    CANCEL(0),
    /** No processing. (Default) (= Activity.RESULT_OK) */
    OK(-1),
}
