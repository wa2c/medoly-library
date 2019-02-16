package com.wa2c.android.medoly.library

import org.junit.After
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


/**
 * Media library utility test.
 */
class MedolyLibraryUtilsTest {

    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun getKeyProperty() {
        val property1 = MedolyLibraryUtils.getKeyProperty("MEDIA_TITLE")
        assertTrue(property1 is MediaProperty)
        assertTrue(property1 === MediaProperty.TITLE)

        val property2 = MedolyLibraryUtils.getKeyProperty("@")
        assertNull(property2)
    }

    @Test
    @Throws(Exception::class)
    fun getPropertyTypeLabel() {
    }

}
