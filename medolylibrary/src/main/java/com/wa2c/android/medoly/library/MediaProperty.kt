package com.wa2c.android.medoly.library

import android.content.Context
import java.util.*

/**
 * Media property.
 */
enum class MediaProperty constructor(override val nameId: Int) : IProperty {
    /** Title  */
    TITLE(R.string.media_title),

    /** Artist.  */
    ARTIST(R.string.media_artist),
    /** Original Artist.  */
    ORIGINAL_ARTIST(R.string.media_original_artist),
    /** Album artist.  */
    ALBUM_ARTIST(R.string.media_album_artist),

    /** Album.  */
    ALBUM(R.string.media_album),
    /** Original album.  */
    ORIGINAL_ALBUM(R.string.media_original_album),

    /** Genre.  */
    GENRE(R.string.media_genre),
    /** Mood.  */
    MOOD(R.string.media_mood),
    /** Occasion.  */
    OCCASION(R.string.media_occasion),

    /** Year.  */
    YEAR(R.string.media_year),
    /** Original year.  */
    ORIGINAL_YEAR(R.string.media_original_year),

    /** Composer.  */
    COMPOSER(R.string.media_composer),
    /** Arranger.  */
    ARRANGER(R.string.media_arranger),
    /** Lyricist.  */
    LYRICIST(R.string.media_lyricist),
    /** Original lyricist.  */
    ORIGINAL_LYRICIST(R.string.media_original_lyricist),
    /** Conductor.  */
    CONDUCTOR(R.string.media_conductor),
    /** Producer.  */
    PRODUCER(R.string.media_producer),
    /** Engineer.  */
    ENGINEER(R.string.media_engineer),
    /** Encoder.  */
    ENCODER(R.string.media_encoder),
    /** Mixer.  */
    MIXER(R.string.media_mixer),
    /** DJ mixer.  */
    DJMIXER(R.string.media_djmixer),
    /** Remixer.  */
    REMIXER(R.string.media_remixer),
    /** Copyright.  */
    COPYRIGHT(R.string.media_copyright),
    /** Label.  */
    RECORD_LABEL(R.string.media_record_label),

    /** Media.  */
    MEDIA(R.string.media_media),
    /** Disc no.  */
    DISC(R.string.media_disc),
    /** Disc total.  */
    DISC_TOTAL(R.string.media_disc_total),
    /** Track no.  */
    TRACK(R.string.media_track),
    /** Track total.  */
    TRACK_TOTAL(R.string.media_track_total),

    /** Comment.  */
    COMMENT(R.string.media_comment),

    /** Loop start.  */
    LOOP_START(R.string.media_loop_start),
    /** Loop length.   */
    LOOP_LENGTH(R.string.media_loop_length),
    /** Tempo.  */
    TEMPO(R.string.media_tempo),
    /** BPM.  */
    BPM(R.string.media_bpm),
    /** BPM for floating point value.  */
    FBPM(R.string.media_fbpm),

    /** Quality.  */
    QUALITY(R.string.media_quality),
    /** Rating.  */
    RATING(R.string.media_rating),

    /** Language.  */
    LANGUAGE(R.string.media_language),
    /** Script.  */
    SCRIPT(R.string.media_script),

    /** Tag.  */
    TAGS(R.string.media_tags),
    /** Key.  */
    KEY(R.string.media_key),
    /** Amazon ID。  */
    AMAZON_ID(R.string.media_amazon_id),
    /** Catalog ID。  */
    CATALOG_NO(R.string.media_catalog_no),
    /** ISRC  */
    ISRC(R.string.media_isrc),

    /** Release official site URL.  */
    URL_OFFICIAL_RELEASE_SITE(R.string.media_url_official_release_site),
    /** Artist official site URL.  */
    URL_OFFICIAL_ARTIST_SITE(R.string.media_url_official_artist_site),
    /** Lyricist official site URL.  */
    URL_LYRICS_SITE(R.string.media_url_lyrics_site),

    // Wikipedia URI
    /** Release wikipedia URL.  */
    URL_WIKIPEDIA_RELEASE_SITE(R.string.media_url_wikipedia_release_site),
    /** Artist wikipedia URL.  */
    URL_WIKIPEDIA_ARTIST_SITE(R.string.media_url_wikipedia_artist_site),

    /** Release discography URL  */
    URL_DISCOGS_RELEASE_SITE(R.string.media_url_discogs_release_site),
    /** Artist discography URL.  */
    URL_DISCOGS_ARTIST_SITE(R.string.media_url_discogs_artist_site),

    /** MusicBrainz release ID.  */
    MUSICBRAINZ_RELEASE_ID(R.string.media_musicbrainz_release_id),
    /** MusicBrainz artist ID.  */
    MUSICBRAINZ_ARTIST_ID(R.string.media_musicbrainz_artist_id),
    /** MusicBrainz release artist ID.  */
    MUSICBRAINZ_RELEASEARTIST_ID(R.string.media_musicbrainz_release_artist_id),
    /** MusicBrainz release group ID.  */
    MUSICBRAINZ_RELEASE_GROUP_ID(R.string.media_musicbrainz_release_group_id),
    /** MusicBrainz disc ID.  */
    MUSICBRAINZ_DISC_ID(R.string.media_musicbrainz_disc_id),
    /** MusicBrainz track ID.  */
    MUSICBRAINZ_TRACK_ID(R.string.media_musicbrainz_track_id),
    /** MusicBrainz work ID.  */
    MUSICBRAINZ_WORK_ID(R.string.media_musicbrainz_work_id),
    /** MusicBrainz release status.  */
    MUSICBRAINZ_RELEASE_STATUS(R.string.media_musicbrainz_release_status),
    /** MusicBrainz release type.  */
    MUSICBRAINZ_RELEASE_TYPE(R.string.media_musicbrainz_release_type),
    /** MusicBrainz release country.  */
    MUSICBRAINZ_RELEASE_COUNTRY(R.string.media_musicbrainz_release_country),

    /** MusicIP ID.  */
    MUSICIP_ID(R.string.media_musicip_id),


    /** Tag type.  */
    TAG_TYPE(R.string.media_tag_type),
    /** Character encoding.  */
    CHARACTER_ENCODING(R.string.media_character_encoding),
    /** Media format.  */
    FORMAT(R.string.media_format),
    /** Media encoding type.  */
    ENCODING_TYPE(R.string.media_encoding_type),
    /** Bit rate.  */
    BIT_RATE(R.string.media_bit_rate),
    /** Sampling rate.  */
    SAMPLE_RATE(R.string.media_sample_rate),
    /** Audio channel.  */
    CHANNELS(R.string.media_channels),
    /** Media duration. (ms)  */
    DURATION(R.string.media_duration),

    /** Description.  */
    DESCRIPTION(R.string.description),
    /** MIME Type.  */
    MIME_TYPE(R.string.mime_type),
    /** Folder path.  */
    FOLDER_PATH(R.string.folder_path),
    /** File base name. */
    FILE_NAME_BASE(R.string.file_name_base),
    /** File name extension. */
    FILE_NAME_EXT(R.string.file_name_ext),
    /** File name. */
    FILE_NAME(R.string.file_name),
    /** Data size.  */
    DATA_SIZE(R.string.data_size),
    /** Last modified date.  */
    LAST_MODIFIED(R.string.last_modified),
    /** URI.  */
    DATA_URI(R.string.data_uri),

    /** Source title.  */
    SOURCE_TITLE(R.string.source_title),
    /** Source URI.  */
    SOURCE_URI(R.string.source_uri);



    /** Property key name  */
    override val keyName: String
        get()  = KEY_PREFIX + "_" + this.name

    /** Get the property name.  */
    override fun getName(context: Context): String {
        return context.getString(nameId)
    }

    companion object {
        /** Prefix to property key name.  */
        const val KEY_PREFIX = "MEDIA"

        /**
         * Map of a key name and a property.
         */
        private val keyPropertyMap = object : HashMap<String, MediaProperty>() {
            init {
                for (p in MediaProperty.values()) {
                    put(p.keyName, p)
                }
            }
        }

        /**
         * Get the property from a key name.
         * @param keyName A key name.
         * @return The property.
         */
        fun valueOfKey(keyName: String): MediaProperty? {
            return keyPropertyMap[keyName]
        }
    }

}
