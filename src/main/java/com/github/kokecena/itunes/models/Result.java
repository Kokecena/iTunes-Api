package com.github.kokecena.itunes.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Result {
    private Integer resultCount;
    private List<Response> results;
}
