package com.github.kokecena.itunes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class Response {
    private String wrapperType;
    private String kind;
    private Long artistId;
    private Long collectionId;
    private Long collectionArtistId;
    private Long trackId;
    private String artistName;
    private String collectionArtistName;
    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String collectionArtistViewUrl;
    private String trackViewUrl;
    private String previewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private Double collectionPrice;
    private Double trackPrice;
    private String collectionExplicitness;
    private String trackExplicitness;
    private Integer discCount;
    private Integer discNumber;
    private Integer trackCount;
    private Integer trackNumber;
    private String releaseDate;
    private Boolean isStreamable;
    private Long trackTimeMillis;
    private String country;
    private String currency;
    private String primaryGenreName;
    private String contentAdvisoryRating;
}
