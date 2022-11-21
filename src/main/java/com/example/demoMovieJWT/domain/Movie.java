package com.example.demoMovieJWT.domain;

import org.springframework.data.annotation.Id;

public class Movie {
    private String movieName;
    @Id
    private int movieId;
    private String yearOfRelease;
    private  String actorName;

    public Movie(String movieName, int movieId, String yearOfRelease, String actorName) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.yearOfRelease = yearOfRelease;
        this.actorName = actorName;
    }

    public Movie() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", movieId=" + movieId +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", actorName='" + actorName + '\'' +
                '}';
    }
}
