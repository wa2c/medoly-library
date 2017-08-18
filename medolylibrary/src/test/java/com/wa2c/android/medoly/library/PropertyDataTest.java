package com.wa2c.android.medoly.library;

import android.net.Uri;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class PropertyDataTest {

    PropertyData propertyData;

    @Before
    public void setUp() throws Exception {
        propertyData = new PropertyData() {{
            put(MediaProperty.TITLE,  new ArrayList<String>() {{ add("Title1");  add("Title2");  }});
            put(MediaProperty.ARTIST, new ArrayList<String>() {{ add("Artist1"); add("Artist2"); }});
            put(MediaProperty.ALBUM,  new ArrayList<String>() {{ add("Album1");  add("Album1");  }});

            put(MediaProperty.COMPOSER, new ArrayList<String>());
            ArrayList<String> list = null;
            put(MediaProperty.LYRICIST, list);

            put(MediaProperty.DATA_URI, "file://localhost/test.mp3");
            put(AlbumArtProperty.DATA_URI, "");


            put(AlbumArtProperty.RESOURCE_TYPE, "EXTERNAL");
        }};
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void containsKey() throws Exception {
        assertTrue(propertyData.containsKey(MediaProperty.TITLE));
        assertTrue(propertyData.containsKey(MediaProperty.TITLE.getKeyName()));
        assertTrue(propertyData.containsKey(MediaProperty.ARTIST));
        assertTrue(propertyData.containsKey(MediaProperty.ARTIST.getKeyName()));
        assertTrue(propertyData.containsKey(MediaProperty.ALBUM));
        assertTrue(propertyData.containsKey(MediaProperty.ALBUM.getKeyName()));

        assertTrue(propertyData.containsKey(MediaProperty.COMPOSER));
        assertTrue(propertyData.containsKey(MediaProperty.LYRICIST));
        assertFalse(propertyData.containsKey(MediaProperty.ARRANGER));
    }

    @Test
    public void containsValue() throws Exception {
        assertFalse(propertyData.containsValue(null));
        assertFalse(propertyData.containsValue("Title1"));
        assertFalse(propertyData.containsValue(new ArrayList<String>() {{ add("Title1"); }}));
        assertTrue(propertyData.containsValue(new ArrayList<String>() {{ add("Title1"); add("Title2"); }}));
        assertTrue(propertyData.containsValue(new ArrayList<String>()));
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(propertyData.isEmpty(MediaProperty.TITLE));
        assertTrue(propertyData.isEmpty(MediaProperty.COMPOSER));
        assertTrue(propertyData.isEmpty(MediaProperty.LYRICIST));

        assertFalse(propertyData.isEmpty(MediaProperty.TITLE.getKeyName()));
        assertTrue(propertyData.isEmpty(MediaProperty.COMPOSER.getKeyName()));
        assertTrue(propertyData.isEmpty(MediaProperty.LYRICIST.getKeyName()));

        assertFalse(propertyData.isEmpty());
        PropertyData p = new PropertyData();
        assertTrue(p.isEmpty());
    }

    @Test
    public void get() throws Exception {
        List<String> val = propertyData.get(MediaProperty.TITLE);
        assertNotNull(val);
        assertTrue(val.equals(new ArrayList<String>() {{ add("Title1"); add("Title2"); }}));
    }

    @Test
    public void getFirst() throws Exception {
        assertEquals(propertyData.getFirst(MediaProperty.TITLE), "Title1");
    }

    @Test
    public void getText() throws Exception {
        String text1 = propertyData.getText(MediaProperty.TITLE);
        assertEquals(text1, "Title1\nTitle2");

        String text2 = propertyData.getText(MediaProperty.ARTIST.getKeyName());
        assertEquals(text2, "Artist1\nArtist2");

        String text3 = propertyData.getText(MediaProperty.TITLE, ",");
        assertEquals(text3, "Title1,Title2");

        String text4 = propertyData.getText(MediaProperty.ARTIST.getKeyName(), " \t ");
        assertEquals(text4, "Artist1 \t Artist2");
    }

    @Test
    public void put() throws Exception {
        propertyData.put(MediaProperty.PRODUCER, new ArrayList<String>() {{ add("Producer1"); add("Producer2"); }} );
        assertFalse(propertyData.isEmpty(MediaProperty.PRODUCER));
        assertTrue(propertyData.get(MediaProperty.PRODUCER).equals(new ArrayList<String>() {{ add("Producer1"); add("Producer2"); }}));

        propertyData.put(MediaProperty.COPYRIGHT.getKeyName(), new ArrayList<String>() {{ add("Copyright1"); add("Copyright2"); }} );
        assertFalse(propertyData.isEmpty(MediaProperty.COPYRIGHT));
        assertTrue(propertyData.get(MediaProperty.COPYRIGHT).equals(new ArrayList<String>() {{ add("Copyright1"); add("Copyright2"); }}));

        propertyData.put(MediaProperty.ORIGINAL_ARTIST, "OriginalArtist1" );
        assertFalse(propertyData.isEmpty(MediaProperty.ORIGINAL_ARTIST));
        assertTrue(propertyData.get(MediaProperty.ORIGINAL_ARTIST).equals(new ArrayList<String>() {{ add("OriginalArtist1"); }}));

        propertyData.put(MediaProperty.ORIGINAL_ALBUM.getKeyName(), "OriginalAlbum1" );
        assertFalse(propertyData.isEmpty(MediaProperty.ORIGINAL_ALBUM));
        assertTrue(propertyData.get(MediaProperty.ORIGINAL_ALBUM).equals(new ArrayList<String>() {{ add("OriginalAlbum1"); }}));
    }

    @Test
    public void insertFirst() throws Exception {
        propertyData.insertFirst(MediaProperty.TITLE, "Title0");
        List<String> val1 = propertyData.get(MediaProperty.TITLE);
        assertTrue(val1.equals(new ArrayList<String>() {{ add("Title0"); add("Title1"); add("Title2"); }}));

        propertyData.insertFirst(MediaProperty.ARTIST, "Artist0");
        List<String> val2 = propertyData.get(MediaProperty.ARTIST);
        assertTrue(val2.equals(new ArrayList<String>() {{ add("Artist0"); add("Artist1"); add("Artist2"); }}));
    }

    @Test
    public void insertLast() throws Exception {
        propertyData.insertLast(MediaProperty.TITLE, "Title3");
        List<String> val1 = propertyData.get(MediaProperty.TITLE);
        assertTrue(val1.equals(new ArrayList<String>() {{ add("Title1"); add("Title2"); add("Title3"); }}));

        propertyData.insertLast(MediaProperty.ARTIST.getKeyName(), "Artist3");
        List<String> val2 = propertyData.get(MediaProperty.ARTIST);
        assertTrue(val2.equals(new ArrayList<String>() {{ add("Artist1"); add("Artist2"); add("Artist3"); }}));
    }

    @Test
    public void remove() throws Exception {
        List<String> list1 = propertyData.get(MediaProperty.TITLE);
        List<String> list2 = propertyData.remove(MediaProperty.TITLE);
        assertEquals(list1, list2);
        assertFalse(propertyData.containsValue(list2));

        List<String> list3 = propertyData.get(MediaProperty.ARTIST);
        List<String> list4 = propertyData.remove(MediaProperty.ARTIST);
        assertEquals(list3, list4);
        assertFalse(propertyData.containsValue(list4));
    }

    @Test
    public void getDataUri() throws Exception {
        assertTrue((Uri.parse("file://localhost/test.mp3")).equals(propertyData.getMediaUri()));
        assertTrue(Uri.parse("").equals(propertyData.getAlbumArtUri()));
        assertTrue(propertyData.getLyricsUri() == null);
    }

    @Test
    public void isDataEmpty() throws Exception {
        assertFalse(propertyData.isMediaEmpty());
        assertFalse(propertyData.isAlbumArtEmpty());
        assertTrue(propertyData.isLyricsEmpty());
    }

    @Test
    public void equals() throws Exception {
        assertTrue(propertyData.equals(MediaProperty.TITLE, new ArrayList<String>() {{ add("Title1"); add("Title2"); }}));
        assertTrue(propertyData.equals(MediaProperty.ARTIST.getKeyName(), new ArrayList<String>() {{ add("Artist1"); add("Artist2"); }}));

        assertTrue(propertyData.equals(MediaProperty.COMPOSER, new ArrayList<String>()));
        assertFalse(propertyData.equals(MediaProperty.COMPOSER, null));
        assertFalse(propertyData.equals(MediaProperty.LYRICIST, new ArrayList<String>()));
        assertTrue(propertyData.equals(MediaProperty.LYRICIST, null));
        assertFalse(propertyData.equals(MediaProperty.ARRANGER, new ArrayList<String>()));
        assertFalse(propertyData.equals(MediaProperty.ARRANGER, null));

        Map<String, List<String>> map = new HashMap<String, List<String>>() {{
            put(MediaProperty.TITLE.getKeyName(),  new ArrayList<String>() {{ add("Title1");  add("Title2");  }});
            put(MediaProperty.ARTIST.getKeyName(), new ArrayList<String>() {{ add("Artist1"); add("Artist2"); }});
            put(MediaProperty.ALBUM.getKeyName(),  new ArrayList<String>() {{ add("Album1");  add("Album1");  }});

            put(MediaProperty.COMPOSER.getKeyName(), new ArrayList<String>());
            ArrayList<String> list = null;
            put(MediaProperty.LYRICIST.getKeyName(), list);
        }};
        assertTrue(propertyData.equals(map));
    }

}