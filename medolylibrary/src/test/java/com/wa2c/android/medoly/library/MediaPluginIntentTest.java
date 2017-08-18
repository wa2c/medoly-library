package com.wa2c.android.medoly.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Media action plugin intent test.
 */
@RunWith(RobolectricTestRunner.class)
public class MediaPluginIntentTest {

    private PropertyData propertyData;
    private ExtraData extraData;
    private MediaPluginIntent eventActionIntent;
    private MediaPluginIntent executionActionIntent;
    private String actionId = String.format(Locale.getDefault(), "%03d", 0) + "_" + System.nanoTime();
    private int actionPriority = 100;


    @Before
    public void setUp() throws Exception {
        propertyData = new PropertyData() {{
            put(MediaProperty.TITLE,  new ArrayList<String>() {{ add("Title1");  add("Title2");  }});
            put(MediaProperty.ARTIST, new ArrayList<String>() {{ add("Artist1"); add("Artist2"); }});
            put(MediaProperty.ALBUM,  new ArrayList<String>() {{ add("Album1");  add("Album1");  }});
        }};
        extraData = new ExtraData() {{
            put("testKey1", "testValue1");
            put("testKey2", new ArrayList<String>(){{ add("testKey2a"); add("testKey2b"); }});
        }};

        // Event intent
        eventActionIntent = new MediaPluginIntent();
        eventActionIntent.addCategory(PluginOperationCategory.OPERATION_EXECUTE);
        eventActionIntent.addCategory(PluginTypeCategory.TYPE_POST_MESSAGE);
        eventActionIntent.setActionId(actionId);
        eventActionIntent.setActionLabel("Event Action");
        eventActionIntent.setActionPriority(null);
        eventActionIntent.setAutomatically(true);
        eventActionIntent.setPropertyData(propertyData);
        eventActionIntent.setExtraData(extraData);
        //eventActionIntent.putExtra(MedolyEnvironment.PLUGIN_EXTRA_KEY, null);
        eventActionIntent.setSrcPackage(MedolyEnvironment.MEDOLY_PACKAGE);
        eventActionIntent.setSrcClass("Receiver");

        // Execution intent
        executionActionIntent = new MediaPluginIntent();
        executionActionIntent.addCategory(PluginOperationCategory.OPERATION_EXECUTE);
        executionActionIntent.addCategory(PluginTypeCategory.TYPE_POST_MESSAGE);
        executionActionIntent.setActionId(actionId);
        executionActionIntent.setActionLabel("Execution Action");
        executionActionIntent.setActionPriority(actionPriority);
        executionActionIntent.setAutomatically(false);
        executionActionIntent.setPropertyData(propertyData);
        executionActionIntent.setExtraData(extraData);
        //eventActionIntent.putExtra(MedolyEnvironment.PLUGIN_EXTRA_KEY, null);
        executionActionIntent.setSrcPackage(MedolyEnvironment.MEDOLY_PACKAGE);
        executionActionIntent.setSrcClass("Receiver");
        executionActionIntent.putExtra("execute_id_test", "execute_id_test");
        executionActionIntent.setClassName(MedolyEnvironment.MEDOLY_PLUGIN_PACKAGE, "Test"); // explicit intent

//        Parcel p = Parcel.obtain();
//        extraData.writeToParcel(p, 0);
//
//        ExtraData dd = ExtraData.CREATOR.createFromParcel(p);
//        ExtraData d = new ExtraData(p);

        ExtraData ed = eventActionIntent.getExtraData();
        System.out.println("");


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getPropertyData() throws Exception {
        PropertyData data = eventActionIntent.getPropertyData();
        assertEquals(propertyData, data);
    }

    @Test
    public void setPropertyData() throws Exception {
        PropertyData data = new PropertyData();
        data.put(MediaProperty.TITLE, "aaa");
        eventActionIntent.setPropertyData(data);
        assertEquals(eventActionIntent.getPropertyData(), data);
    }

    @Test
    public void getExtraData() throws Exception {
        ExtraData data = eventActionIntent.getExtraData();
        assertEquals(extraData, data);
    }

    @Test
    public void setExtraData() throws Exception {
        ExtraData data = new ExtraData();
        data.put("abc", "def");
        eventActionIntent.setExtraData(data);
        assertEquals(eventActionIntent.getExtraData(), data);
    }

    @Test
    public void getActionLabel() throws Exception {
        assertEquals(eventActionIntent.getActionLabel(), "Event Action");
    }

    @Test
    public void setActionLabel() throws Exception {
        eventActionIntent.setActionLabel("test");
        assertEquals(eventActionIntent.getActionLabel(), "test");
    }

    @Test
    public void getActionId() throws Exception {
        assertEquals(eventActionIntent.getActionId(), actionId);
    }

    @Test
    public void setActionId() throws Exception {
        eventActionIntent.setActionId("test");
        assertEquals(eventActionIntent.getActionId(), "test");
    }

    @Test
    public void getActionPriority() throws Exception {
        assertEquals(eventActionIntent.getActionPriority(), -1);
        assertEquals(executionActionIntent.getActionPriority(), actionPriority);
    }

    @Test
    public void setActionPriority() throws Exception {
        eventActionIntent.setActionPriority(999);
        assertEquals(eventActionIntent.getActionPriority(), 999);
    }

    @Test
    public void isAutomatically() throws Exception {
        assertTrue(eventActionIntent.isAutomatically());
        assertFalse(executionActionIntent.isAutomatically());
    }

    @Test
    public void setAutomatically() throws Exception {
        eventActionIntent.setAutomatically(false);
        assertFalse(eventActionIntent.isAutomatically());
    }

    @Test
    public void hasCategories() throws Exception {
        assertTrue(eventActionIntent.hasCategory(PluginOperationCategory.OPERATION_EXECUTE));
        assertFalse(eventActionIntent.hasCategory(PluginOperationCategory.OPERATION_MEDIA_OPEN));
        assertTrue(eventActionIntent.hasCategory(PluginTypeCategory.TYPE_POST_MESSAGE));
        assertFalse(eventActionIntent.hasCategory(PluginTypeCategory.TYPE_RUN));
    }

    @Test
    public void getSrc() throws Exception {
        assertEquals(eventActionIntent.getSrcPackage(), MedolyEnvironment.MEDOLY_PACKAGE);
        assertEquals(eventActionIntent.getSrcClass(), "Receiver");
   }

    @Test
    public void setSrc() throws Exception {
        eventActionIntent.setSrcPackage("TestPackage");
        assertEquals(eventActionIntent.getSrcPackage(), "TestPackage");

        eventActionIntent.setSrcClass("TestClass");
        assertEquals(eventActionIntent.getSrcClass(), "TestClass");
    }

    @Test
    public void createIntent() throws Exception {
        MediaPluginIntent returnIntent1 = eventActionIntent.createResultIntent(propertyData);
        assertEquals(returnIntent1.getComponent().getPackageName(), eventActionIntent.getSrcPackage());
        assertEquals(returnIntent1.getComponent().getClassName(), eventActionIntent.getSrcClass());
        assertEquals(returnIntent1.getPropertyData(), propertyData);
        assertEquals(returnIntent1.getActionId(), eventActionIntent.getActionId());
        assertEquals(returnIntent1.getActionLabel(), eventActionIntent.getActionLabel());

        eventActionIntent.setSrcClass(null);
        MediaPluginIntent returnIntent2 = eventActionIntent.createResultIntent(null);
        assertEquals(returnIntent2.getPackage(), eventActionIntent.getSrcPackage());
        assertNull(returnIntent2.getComponent());
        assertEquals(returnIntent2.getPropertyData(), null);
    }

}