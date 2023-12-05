package com.github.kokecena.itunes;

import com.github.kokecena.itunes.service.ITunesService;
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Facilitates interaction with the iTunes Search API through a Retrofit service.
 */
public class ITunes {
    private static final Logger log = LoggerFactory.getLogger(ITunes.class);
    private static final String BASE_URL = "https://itunes.apple.com/";
    private final Retrofit retrofit;

    /**
     * Constructs an instance of the ITunes class.
     *
     * @param userAgent The user agent string to be used in the HTTP headers for requests.
     * @throws IllegalArgumentException if the user agent is null or blank.
     */
    public ITunes(String userAgent) {
        if (userAgent == null || userAgent.isBlank()) {
            throw new IllegalArgumentException("User agent must have a value.");
        }
        this.retrofit = buildRetrofitService(userAgent);
    }

    private Retrofit buildRetrofitService(String userAgent) {
        Interceptor interceptorDelay = chain -> {
            try {
                TimeUnit.MILLISECONDS.sleep( 2400L );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return chain.proceed(chain.request());
        };
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(log::debug);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient okHttpClient;
        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptorDelay)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Request requestWithUserAgent = request.newBuilder()
                            .addHeader("User-Agent", userAgent)
                            .method(request.method(), request.body())
                            .build();
                    return chain.proceed(requestWithUserAgent);
                }).addInterceptor(loggingInterceptor).build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    /**
     * Provides access to the iTunesService interface for making requests to the iTunes Search API.
     *
     * @return An instance of the ITunesService interface.
     */
    public ITunesService itunesService() {
        return retrofit.create(ITunesService.class);
    }

}
