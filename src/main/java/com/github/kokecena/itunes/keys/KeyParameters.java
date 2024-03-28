package com.github.kokecena.itunes.keys;

/**
 * Parameters for search query
 */
public class KeyParameters {

    private KeyParameters() {
    }

    /**
     * The URL-encoded text string you want to search for. For example: jack+johnson.
     */
    public static final String TERM = "term";
    /**
     * The two-letter country code for the store you want to search. The search uses the default store front for the specified country. For example: US. The default is US.
     */
    public static final String COUNTRY = "country";
    /**
     * The media type you want to search for. For example: movie. The default is all.
     */
    public static final String MEDIA = "media";
    /**
     * The type of results you want returned, relative to the specified media type. For example: movieArtist for a movie media type search. The default is the track entity associated with the specified media type.
     */
    public static final String ENTITY = "entity";
    /**
     * The attribute you want to search for in the stores, relative to the specified media type. For example, if you want to search for an artist by name specify entity=allArtist&attribute=allArtistTerm. In this example, if you search for term=maroon, iTunes returns “Maroon 5” in the search results, instead of all artists who have ever recorded a song with the word “maroon” in the title.
     * The default is all attributes associated with the specified media type.
     */
    public static final String ATTRIBUTE = "attribute";
    /**
     * The name of the Javascript callback function you want to use when returning search results to your website.
     */
    public static final String CALLBACK = "callback";
    /**
     * The number of search results you want the iTunes Store to return. For example: 25. The default is 50.
     */
    public static final String LIMIT = "limit";
    /**
     * The language, English or Japanese, you want to use when returning search results. Specify the language using the five-letter codename. For example: en_us. The default is en_us (English).
     */
    public static final String LANG = "lang";
    /**
     * The search result key version you want to receive back from your search. The default is 2.
     */
    public static final String VERSION = "version";
    /**
     * A flag indicating whether or not you want to include explicit content in your search results. The default is Yes.
     */
    public static final String EXPLICIT = "explicit";

}