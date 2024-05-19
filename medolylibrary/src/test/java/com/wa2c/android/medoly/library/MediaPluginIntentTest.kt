package com.wa2c.android.medoly.library

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.*

/**
 * Media action plugin intent test.
 */
@RunWith(RobolectricTestRunner::class)
class MediaPluginIntentTest {

    private lateinit var propertyData: PropertyData
    private lateinit var extraData: ExtraData
    private lateinit var eventActionIntent: MediaPluginIntent
    private lateinit var executionActionIntent: MediaPluginIntent
    private val actionId = String.format(Locale.getDefault(), "%03d", 0) + "_" + System.nanoTime()
    private val actionPriority = 100

    @Before
    @Throws(Exception::class)
    fun setUp() {

        propertyData = object : PropertyData() {
            init {
                put(MediaProperty.TITLE, object : ArrayList<String?>() {
                    init {
                        add("Title1")
                        add("Title2")
                    }
                })
                put(MediaProperty.ARTIST, object : ArrayList<String?>() {
                    init {
                        add("Artist1")
                        add("Artist2")
                    }
                })
                put(MediaProperty.ALBUM, object : ArrayList<String?>() {
                    init {
                        add("Album1")
                        add("Album1")
                    }
                })
            }
        }
        extraData = object : ExtraData() {
            init {
                put("testKey1", "testValue1")
                put("testKey2", object : ArrayList<String?>() {
                    init {
                        add("testKey2a")
                        add("testKey2b")
                    }
                })
            }
        }

        // Event intent
        eventActionIntent = MediaPluginIntent()
        eventActionIntent.addCategory(PluginOperationCategory.OPERATION_EXECUTE)
        eventActionIntent.addCategory(PluginTypeCategory.TYPE_POST_MESSAGE)
        eventActionIntent.actionId = actionId
        eventActionIntent.actionLabel = "Event Action"
        eventActionIntent.actionPriority = null
        eventActionIntent.isAutomatically = true
        eventActionIntent.propertyData = propertyData
        eventActionIntent.extraData = extraData
        //eventActionIntent.putExtra(MedolyEnvironment.PLUGIN_EXTRA_KEY, null);
        eventActionIntent.srcPackage = MedolyEnvironment.MEDOLY_PACKAGE
        eventActionIntent.srcClass = "Receiver"

        // Execution intent
        executionActionIntent = MediaPluginIntent()
        executionActionIntent.addCategory(PluginOperationCategory.OPERATION_EXECUTE)
        executionActionIntent.addCategory(PluginTypeCategory.TYPE_POST_MESSAGE)
        executionActionIntent.actionId = actionId
        executionActionIntent.actionLabel = "Execution Action"
        executionActionIntent.actionPriority = actionPriority
        executionActionIntent.isAutomatically = false
        executionActionIntent.propertyData = propertyData
        executionActionIntent.extraData = extraData
        //eventActionIntent.putExtra(MedolyEnvironment.PLUGIN_EXTRA_KEY, null);
        executionActionIntent.srcPackage = MedolyEnvironment.MEDOLY_PACKAGE
        executionActionIntent.srcClass = "Receiver"
        executionActionIntent.putExtra("execute_id_test", "execute_id_test")
        executionActionIntent.setClassName(MedolyEnvironment.MEDOLY_PLUGIN_PACKAGE, "Test") // explicit intent
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

    }

    @Test
    @Throws(Exception::class)
    fun getPropertyData() {
        val data = eventActionIntent.propertyData
        assertEquals(propertyData, data)
    }

    @Test
    @Throws(Exception::class)
    fun setPropertyData() {
        val data = PropertyData()
        data[MediaProperty.TITLE] = "aaa"
        eventActionIntent.propertyData = data
        assertEquals(eventActionIntent.propertyData, data)
    }

    @Test
    @Throws(Exception::class)
    fun getExtraData() {
        val data = eventActionIntent.extraData
        assertEquals(extraData, data)
    }

    @Test
    @Throws(Exception::class)
    fun setExtraData() {
        val data = ExtraData()
        data["abc"] = "def"
        eventActionIntent.extraData = data
        assertEquals(eventActionIntent.extraData, data)
    }

    @Test
    @Throws(Exception::class)
    fun getActionLabel() {
        assertEquals(eventActionIntent.actionLabel, "Event Action")
    }

    @Test
    @Throws(Exception::class)
    fun setActionLabel() {
        eventActionIntent.actionLabel = "test"
        assertEquals(eventActionIntent.actionLabel, "test")
    }

    @Test
    @Throws(Exception::class)
    fun getActionId() {
        assertEquals(eventActionIntent.actionId, actionId)
    }

    @Test
    @Throws(Exception::class)
    fun setActionId() {
        eventActionIntent.actionId = "test"
        assertEquals(eventActionIntent.actionId, "test")
    }

    @Test
    @Throws(Exception::class)
    fun getActionPriority() {
        assertEquals(eventActionIntent.actionPriority, -1)
        assertEquals(executionActionIntent.actionPriority, actionPriority)
    }

    @Test
    @Throws(Exception::class)
    fun setActionPriority() {
        eventActionIntent.actionPriority = 999
        assertEquals(eventActionIntent.actionPriority, 999)
    }

    @Test
    @Throws(Exception::class)
    fun isAutomatically() {
        assertTrue(eventActionIntent.isAutomatically)
        assertFalse(executionActionIntent.isAutomatically)
    }

    @Test
    @Throws(Exception::class)
    fun setAutomatically() {
        eventActionIntent.isAutomatically = false
        assertFalse(eventActionIntent.isAutomatically)
    }

    @Test
    @Throws(Exception::class)
    fun hasCategories() {
        assertTrue(eventActionIntent.hasCategory(PluginOperationCategory.OPERATION_EXECUTE))
        assertFalse(eventActionIntent.hasCategory(PluginOperationCategory.OPERATION_MEDIA_OPEN))
        assertTrue(eventActionIntent.hasCategory(PluginTypeCategory.TYPE_POST_MESSAGE))
        assertFalse(eventActionIntent.hasCategory(PluginTypeCategory.TYPE_RUN))
    }

    @Test
    @Throws(Exception::class)
    fun getSrc() {
        assertEquals(eventActionIntent.srcPackage, MedolyEnvironment.MEDOLY_PACKAGE)
        assertEquals(eventActionIntent.srcClass, "Receiver")
    }

    @Test
    @Throws(Exception::class)
    fun setSrc() {
        eventActionIntent.srcPackage = "TestPackage"
        assertEquals(eventActionIntent.srcPackage, "TestPackage")

        eventActionIntent.srcClass = "TestClass"
        assertEquals(eventActionIntent.srcClass, "TestClass")
    }

    @Test
    @Throws(Exception::class)
    fun createIntent() {
        val returnIntent1 = eventActionIntent.createResultIntent(propertyData)
        assertEquals(returnIntent1.component?.packageName, eventActionIntent.srcPackage)
        assertEquals(returnIntent1.component?.className, eventActionIntent.srcClass)
        assertEquals(returnIntent1.propertyData, propertyData)
        assertEquals(returnIntent1.actionId, eventActionIntent.actionId)
        assertEquals(returnIntent1.actionLabel, eventActionIntent.actionLabel)

        eventActionIntent.srcClass = null
        val returnIntent2 = eventActionIntent.createResultIntent(null)
        assertEquals(returnIntent2.`package`, eventActionIntent.srcPackage)
        assertNull(returnIntent2.component)
        assertEquals(returnIntent2.propertyData, null)
    }

}
