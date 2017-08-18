package com.wa2c.android.medoly.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


/**
 * Media library utility test.
 */
public class MedolyLibraryUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getKeyProperty() throws Exception {
        IProperty property1 = MedolyLibraryUtils.getKeyProperty("MEDIA_TITLE");
        assertTrue(property1 instanceof MediaProperty);
        assertTrue(property1 == MediaProperty.TITLE);

        IProperty property2 = MedolyLibraryUtils.getKeyProperty("@");
        assertNull(property2);
    }

    @Test
    public void getPropertyTypeLabel() throws Exception {
    }

}