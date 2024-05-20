package com.wa2c.android.medoly.library

import android.net.Uri
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.*


@RunWith(RobolectricTestRunner::class)
class PropertyDataTest {

    private lateinit var propertyData: PropertyData

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

                put(MediaProperty.COMPOSER, ArrayList())
                val list: ArrayList<String?>? = null
                put(MediaProperty.LYRICIST, list)

                put(MediaProperty.DATA_URI, "http://localhost/test.mp3")
                put(AlbumArtProperty.DATA_URI, "")
                put(AlbumArtProperty.RESOURCE_TYPE, "EXTERNAL")
            }
        }
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

    }

    @Test
    @Throws(Exception::class)
    fun copyConstructor() {
        val copyData = PropertyData(propertyData)
        assertTrue(propertyData == copyData)
        assertFalse(propertyData === copyData)
    }

    @Test
    @Throws(Exception::class)
    fun containsKey() {
        assertTrue(propertyData.containsKey(MediaProperty.TITLE))
        assertTrue(propertyData.containsKey(MediaProperty.TITLE.keyName))
        assertTrue(propertyData.containsKey(MediaProperty.ARTIST))
        assertTrue(propertyData.containsKey(MediaProperty.ARTIST.keyName))
        assertTrue(propertyData.containsKey(MediaProperty.ALBUM))
        assertTrue(propertyData.containsKey(MediaProperty.ALBUM.keyName))

        assertTrue(propertyData.containsKey(MediaProperty.COMPOSER))
        assertTrue(propertyData.containsKey(MediaProperty.LYRICIST))
        assertFalse(propertyData.containsKey(MediaProperty.ARRANGER))
    }

    @Test
    @Throws(Exception::class)
    fun containsValue() {
        assertFalse(propertyData.containsValue(null as String?))
        assertFalse(propertyData.containsValue("Title1"))
        assertFalse(propertyData.containsValue(object : ArrayList<String?>() {
            init {
                add("Title1")
            }
        }))
        assertTrue(propertyData.containsValue(object : ArrayList<String?>() {
            init {
                add("Title1")
                add("Title2")
            }
        }))
        assertTrue(propertyData.containsValue(ArrayList()))
    }

    @Test
    @Throws(Exception::class)
    fun isEmpty() {
        assertFalse(propertyData.isEmpty(MediaProperty.TITLE))
        assertTrue(propertyData.isEmpty(MediaProperty.COMPOSER))
        assertTrue(propertyData.isEmpty(MediaProperty.LYRICIST))

        assertFalse(propertyData.isEmpty(MediaProperty.TITLE.keyName))
        assertTrue(propertyData.isEmpty(MediaProperty.COMPOSER.keyName))
        assertTrue(propertyData.isEmpty(MediaProperty.LYRICIST.keyName))

        assertFalse(propertyData.isEmpty())
        val p = PropertyData()
        assertTrue(p.isEmpty())
    }

    @Test
    @Throws(Exception::class)
    fun get() {
        val v = propertyData[MediaProperty.TITLE]
        assertNotNull(v)
        assertTrue(v == object : ArrayList<String?>() {
            init {
                add("Title1")
                add("Title2")
            }
        })
    }

    @Test
    @Throws(Exception::class)
    fun getFirst() {
        assertEquals(propertyData.getFirst(MediaProperty.TITLE), "Title1")
    }

    @Test
    @Throws(Exception::class)
    fun getText() {
        val text1 = propertyData.getText(MediaProperty.TITLE)
        assertEquals(text1, "Title1\nTitle2")

        val text2 = propertyData.getText(MediaProperty.ARTIST.keyName)
        assertEquals(text2, "Artist1\nArtist2")

        val text3 = propertyData.getText(MediaProperty.TITLE, ",")
        assertEquals(text3, "Title1,Title2")

        val text4 = propertyData.getText(MediaProperty.ARTIST.keyName, " \t ")
        assertEquals(text4, "Artist1 \t Artist2")
    }

    @Test
    @Throws(Exception::class)
    fun put() {
        propertyData[MediaProperty.PRODUCER] = object : ArrayList<String?>() {
            init {
                add("Producer1")
                add("Producer2")
            }
        }
        assertFalse(propertyData.isEmpty(MediaProperty.PRODUCER))
        assertTrue(propertyData[MediaProperty.PRODUCER] == object : ArrayList<String?>() {
            init {
                add("Producer1")
                add("Producer2")
            }
        })

        propertyData[MediaProperty.ENGINEER] = object : ArrayList<String?>() {
            init {
                add("Engineer1")
                add("Engineer2")
            }
        }
        assertFalse(propertyData.isEmpty(MediaProperty.ENGINEER))
        assertTrue(propertyData[MediaProperty.ENGINEER] == object : ArrayList<String?>() {
            init {
                add("Engineer1")
                add("Engineer2")
            }
        })



        propertyData[MediaProperty.COPYRIGHT.keyName] = object : ArrayList<String?>() {
            init {
                add("Copyright1")
                add("Copyright2")
            }
        }
        assertFalse(propertyData.isEmpty(MediaProperty.COPYRIGHT))
        assertTrue(propertyData[MediaProperty.COPYRIGHT] == object : ArrayList<String?>() {
            init {
                add("Copyright1")
                add("Copyright2")
            }
        })

        propertyData[MediaProperty.RECORD_LABEL.keyName] = object : ArrayList<String?>() {
            init {
                add("RecordLabel1")
                add("RecordLabel2")
            }
        }
        assertFalse(propertyData.isEmpty(MediaProperty.RECORD_LABEL))
        assertTrue(propertyData[MediaProperty.RECORD_LABEL] == object : ArrayList<String?>() {
            init {
                add("RecordLabel1")
                add("RecordLabel2")
            }
        })



        propertyData[MediaProperty.ORIGINAL_ARTIST] = "OriginalArtist1"
        assertFalse(propertyData.isEmpty(MediaProperty.ORIGINAL_ARTIST))
        assertTrue(propertyData[MediaProperty.ORIGINAL_ARTIST] == object : ArrayList<String?>() {
            init {
                add("OriginalArtist1")
            }
        })

        propertyData[MediaProperty.ORIGINAL_LYRICIST] = "OriginalLyricist1"
        assertFalse(propertyData.isEmpty(MediaProperty.ORIGINAL_LYRICIST))
        assertTrue(propertyData[MediaProperty.ORIGINAL_LYRICIST] == object : ArrayList<String?>() {
            init {
                add("OriginalLyricist1")
            }
        })



        propertyData[MediaProperty.ORIGINAL_ALBUM.keyName] = "OriginalAlbum1"
        assertFalse(propertyData.isEmpty(MediaProperty.ORIGINAL_ALBUM))
        assertTrue(propertyData[MediaProperty.ORIGINAL_ALBUM] == object : ArrayList<String?>() {
            init {
                add("OriginalAlbum1")
            }
        })

        propertyData[MediaProperty.ORIGINAL_YEAR .keyName] = "OriginalYear1"
        assertFalse(propertyData.isEmpty(MediaProperty.ORIGINAL_YEAR))
        assertTrue(propertyData[MediaProperty.ORIGINAL_YEAR] == object : ArrayList<String?>() {
            init {
                add("OriginalYear1")
            }
        })
    }

    @Test
    @Throws(Exception::class)
    fun insertFirst() {
        propertyData.insertFirst(MediaProperty.TITLE, "Title0")
        val v1 = propertyData[MediaProperty.TITLE]
        assertTrue(v1 == object : ArrayList<String?>() {
            init {
                add("Title0")
                add("Title1")
                add("Title2")
            }
        })

        propertyData.insertFirst(MediaProperty.ARTIST, "Artist0")
        val v2 = propertyData[MediaProperty.ARTIST]
        assertTrue(v2 == object : ArrayList<String?>() {
            init {
                add("Artist0")
                add("Artist1")
                add("Artist2")
            }
        })
    }

    @Test
    @Throws(Exception::class)
    fun insertLast() {
        propertyData.insertLast(MediaProperty.TITLE, "Title3")
        val val1 = propertyData[MediaProperty.TITLE]
        assertTrue(val1 == object : ArrayList<String?>() {
            init {
                add("Title1")
                add("Title2")
                add("Title3")
            }
        })

        propertyData.insertLast(MediaProperty.ARTIST.keyName, "Artist3")
        val val2 = propertyData[MediaProperty.ARTIST]
        assertTrue(val2 == object : ArrayList<String?>() {
            init {
                add("Artist1")
                add("Artist2")
                add("Artist3")
            }
        })
    }

    @Test
    @Throws(Exception::class)
    fun remove() {
        val list1 = propertyData[MediaProperty.TITLE]
        val list2 = propertyData.remove(MediaProperty.TITLE)
        assertEquals(list1, list2)
        assertFalse(propertyData.containsValue(list2))

        val list3 = propertyData[MediaProperty.ARTIST]
        val list4 = propertyData.remove(MediaProperty.ARTIST)
        assertEquals(list3, list4)
        assertFalse(propertyData.containsValue(list4))
    }

    @Test
    @Throws(Exception::class)
    fun getDataUri() {
        assertTrue(Uri.parse("http://localhost/test.mp3") == propertyData.mediaUri)
        assertTrue(propertyData.albumArtUri == null)
        assertTrue(propertyData.lyricsUri == null)
    }

    @Test
    @Throws(Exception::class)
    fun isDataEmpty() {
        assertFalse(propertyData.isMediaEmpty)
        assertFalse(propertyData.isAlbumArtEmpty)
        assertTrue(propertyData.isLyricsEmpty)
    }

    @Test
    @Throws(Exception::class)
    fun equals() {
        assertTrue(propertyData.equals(MediaProperty.TITLE, object : ArrayList<String?>() {
            init {
                add("Title1")
                add("Title2")
            }
        }))
        assertTrue(propertyData.equals(MediaProperty.ARTIST.keyName, object : ArrayList<String?>() {
            init {
                add("Artist1")
                add("Artist2")
            }
        }))

        assertTrue(propertyData.equals(MediaProperty.COMPOSER, ArrayList()))
        assertFalse(propertyData.equals(MediaProperty.COMPOSER, null))
        assertFalse(propertyData.equals(MediaProperty.LYRICIST, ArrayList()))
        assertTrue(propertyData.equals(MediaProperty.LYRICIST, null))
        assertFalse(propertyData.equals(MediaProperty.ARRANGER, ArrayList()))
        assertFalse(propertyData.equals(MediaProperty.ARRANGER, null))

        val map = object : HashMap<String, MutableList<String?>?>() {
            init {
                put(MediaProperty.TITLE.keyName, object : ArrayList<String?>() {
                    init {
                        add("Title1")
                        add("Title2")
                    }
                })
                put(MediaProperty.ARTIST.keyName, object : ArrayList<String?>() {
                    init {
                        add("Artist1")
                        add("Artist2")
                    }
                })
                put(MediaProperty.ALBUM.keyName, object : ArrayList<String?>() {
                    init {
                        add("Album1")
                        add("Album1")
                    }
                })

                put(MediaProperty.COMPOSER.keyName, ArrayList())
                val list: ArrayList<String?>? = null
                put(MediaProperty.LYRICIST.keyName, list)

                put(MediaProperty.DATA_URI.keyName, object : ArrayList<String?>() { init { add("http://localhost/test.mp3") } })
                put(AlbumArtProperty.DATA_URI.keyName, object : ArrayList<String?>() { init { add("") } })
                put(AlbumArtProperty.RESOURCE_TYPE.keyName, object : ArrayList<String?>() { init { add("EXTERNAL") } })
            }
        }
        assertTrue(propertyData.equals(map))

        val copyData = PropertyData(map)
        assertEquals(propertyData, copyData)
        assertFalse(propertyData === copyData)
    }

    @Test
    @Throws(Exception::class)
    fun clone() {
        assertTrue(propertyData == propertyData.clone())
        assertFalse(propertyData === propertyData.clone())
    }
}
