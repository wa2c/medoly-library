package com.wa2c.android.medoly.library

import java.util.*

/**
 * Property data.
 */
open class ExtraData : LinkedHashMap<String?, MutableList<String?>?> {

    /**
     * Constructor.
     */
    constructor() : super()

    /**
     * Constructor.
     * @param capacity The capacity.
     */
    constructor(capacity: Int) : super(capacity)

    /**
     * Copy constructor.
     * @param propertyData A extra data.
     */
    constructor(propertyData: Map<String, MutableList<String?>?>) : super(propertyData)

    /**
     * Copy constructor.
     * @param propertyData A extra data.
     */
    constructor(propertyData: PropertyData) : super(propertyData)


    /**
     * Returns true if this map maps one or more keys to the specified value.
     * @param value A property value.
     * @return true if this map maps one or more keys to the specified value.
     */
    fun containsValue(value: String?): Boolean {
        return containsValue(mutableListOf(value))
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     * @param value A property value.
     * @return true if this map maps one or more keys to the specified value.
     */
    override fun containsValue(value: MutableList<String?>?): Boolean {
        return if (value == null)
            false
        else
            this.keys.any { equals(it, value) }
    }

    /**
     * Returns true if this map contains no key-value mappings.
     * @param key key whose presence in this map is to be tested.
     * @return true if this map contains no key-value mappings.
     */
    fun isEmpty(key: String?): Boolean {
        val list = this[key]
        return (list == null || list.isEmpty())
    }

    /**
     * Get the first property value.
     * @param key A property key.
     * @return The first property value.
     */
    fun getFirst(key: String?): String? {
        val list = this[key]
        return if (list == null || list.isEmpty()) null else list[0]
    }

    /**
     * Get the values concatenated by separator as text.
     * @param key A property key.
     * @param separator A separator.
     * @return The concatenated property text.
     */
    @JvmOverloads
    fun getText(key: String?, separator: String? = "\n"): String {
        var sep = separator
        val list = this[key]
        if (list == null || list.isEmpty())
            return ""
        if (list.size == 1)
            return list[0] ?: ""
        if (sep == null)
            sep = ""

        val builder = StringBuilder()
        for (text in list) {
            builder.append(text).append(sep)
        }
        return builder.substring(0, builder.length - sep.length)
    }

    /**
     * Set the new property value list. (indexed access operator)
     * @param key A property key.
     * @param value The property value.
     */
    operator fun set(key: String?, value: MutableList<String?>?): MutableList<String?>? {
        return put(key, value)
    }

    /**
     * Set the new property value list. (indexed access operator)
     * @param key A property key.
     * @param value The property value.
     */
    operator fun set(key: String?, value: String?): MutableList<String?>? {
        return put(key, value)
    }

    /**
     * Put the new property value.
     * @param key A property key.
     * @param value The property value.
     */
    fun put(key: String?, value: String?): MutableList<String?>? {
        return super.put(key, mutableListOf(value))
    }

    /**
     * Insert the property value to first position.
     * @param key A property key.
     * @param value The property value.
     */
    fun insertFirst(key: String?, value: String?) {
        var list = get(key)
        if (list == null) {
            list = mutableListOf()
            this[key] = list
        }
        list.add(0, value)
    }

    /**
     * Insert the property value to last position.
     * @param key A property key.
     * @param value The property value.
     */
    fun insertLast(key: String?, value: String?) {
        var list = get(key)
        if (list == null) {
            list = mutableListOf()
            this[key] = list
        }
        list.add(value)
    }


    /**
     * Compares the specified obj with this map for equality.
     * @return true if the specified obj is equal to this map.
     */
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Map<*, *>?)
            return false

        try {
            val map = other as Map<*, MutableList<String?>?>?
            if (map == null || map.size != this.size)
                return false
            for (key in this.keys) {
                if (!this.equals(key, map[key]))
                    return false
            }
        } catch (e: RuntimeException) {
            return false
        }

        return true
    }

    /**
     * Compares the specified object with this map for equality.
     * @param key A key key.
     * @param list A key value list.
     * @return true if the specified object is equal to this map.
     */
    fun equals(key: String?, list: MutableList<String?>?): Boolean {
        if (!this.containsKey(key))
            return false

        val thisList = this[key]
        if (list == null && thisList == null) {
            return true
        }

        if (list == null || thisList == null || list.size != thisList.size)
            return false

        if (list.isEmpty() && thisList.isEmpty())
            return true

        for (i in list.indices) {
            val a = list[i]
            val b = thisList[i]
            if (a == null || b == null)
                return false
            if (a != b)
                return false
        }
        return true
    }

    /**
     * Creates and returns a copy of this object.
     * @return A clone of this instance.
     */
    override fun clone(): ExtraData {
        return super.clone() as ExtraData
    }

}
