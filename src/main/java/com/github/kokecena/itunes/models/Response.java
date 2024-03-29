package com.github.kokecena.itunes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Response {
    private Integer resultCount;
    @JsonProperty("results")
    private List<Track> tracks;
}
