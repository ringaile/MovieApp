package com.example.ringaile.movieapp;

import java.io.Serializable;

/**
 * Created by ringaile on 21/10/15.
 * Generated with http://www.jsonschema2pojo.org
 */
public class Movie implements Serializable {

    private String theaterId;
    private String theaterName;
    private String movieId;
    private String movieTitle;
    private String movieGenre;
    private String movieRating;
    private String movieImageUrl;
    private String movieDuration;
    private String time;
    private String info;


    public Movie(String theaterId, String theaterName, String movieId, String movieTitle, String movieGenre, String movieRating, String movieImageUrl, String movieDuration, String time, String info) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieRating = movieRating;
        this.movieImageUrl = movieImageUrl;
        this.movieDuration = movieDuration;
        this.time = time;
        this.info = info;
    }
    /**
     *
     * @return
     * The theaterId
     */
    public String getTheaterId() {
        return theaterId;
    }

    /**
     *
     * @param theaterId
     * The theaterId
     */
    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    /**
     *
     * @return
     * The theaterName
     */
    public String getTheaterName() {
        return theaterName;
    }

    /**
     *
     * @param theaterName
     * The theaterName
     */
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    /**
     *
     * @return
     * The movieId
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     *
     * @param movieId
     * The movieId
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     *
     * @return
     * The movieTitle
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     *
     * @param movieTitle
     * The movieTitle
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     *
     * @return
     * The movieGenre
     */
    public String getMovieGenre() {
        return movieGenre;
    }

    /**
     *
     * @param movieGenre
     * The movieGenre
     */
    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    /**
     *
     * @return
     * The movieRating
     */
    public String getMovieRating() {
        return movieRating;
    }

    /**
     *
     * @param movieRating
     * The movieRating
     */
    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    /**
     *
     * @return
     * The movieImageUrl
     */
    public String getMovieImageUrl() {
        return movieImageUrl;
    }

    /**
     *
     * @param movieImageUrl
     * The movieImageUrl
     */
    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }

    /**
     *
     * @return
     * The movieDuration
     */
    public String getMovieDuration() {
        return movieDuration;
    }

    /**
     *
     * @param movieDuration
     * The movieDuration
     */
    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    /**
     *
     * @return
     * The time
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     *
     * @return
     * The info
     */
    public String getInfo() {
        return info;
    }

    /**
     *
     * @param info
     * The info
     */
    public void setInfo(String info) {
        this.info = info;
    }


}

