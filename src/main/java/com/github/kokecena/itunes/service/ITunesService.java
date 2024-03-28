package com.github.kokecena.itunes.service;

import com.github.kokecena.itunes.keys.KeyParameters;
import com.github.kokecena.itunes.models.Response;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * Service interface for interacting with the iTunes Search API.
 */
public interface ITunesService {

    /**
     * Searches for content in the iTunes Store based on the specified query parameters.
     *
     * @param query A map containing query parameters for the search. Use {@link KeyParameters} enum for keys.
     * @return A Mono emitting a {@link Response} object representing the search results.
     */
    @GET("search")
    Mono<Response> search(@QueryMap Map<String, String> query);
}
