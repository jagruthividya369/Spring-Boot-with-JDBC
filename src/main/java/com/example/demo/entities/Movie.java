package com.example.demo.entities;

public class Movie {
    private Integer movieId;
    private String movieName;
    private String movieDirector;
    private Double imdbRating;

    public Movie() {
    }

    public Movie(Integer movieId, String movieName, String movieDirector, Double imdbRating) {
        this.movieId=movieId;
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.imdbRating = imdbRating;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                "movieName='" + movieName + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", imdbRating=" + imdbRating +
                '}';
    }
}
