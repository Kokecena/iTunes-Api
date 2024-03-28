package com.github.kokecena.itunes.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Response {
    private Integer resultCount;
    private List<Track> tracks;
}
