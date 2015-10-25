package com.example.ringaile.movieapp;

/**
 * Created by ringaile on 25/10/15.
 */
import retrofit.http.GET;
import retrofit.http.Query;

public interface IApiMethods {

    @GET("/get/today.json")
    Movie getMovies(
            @Query("api_key") String key
    );
}