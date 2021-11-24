package com.example.demo.repository;

import com.example.demo.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    String qry;

    public List<Movie> displayAllMoviesFromRepository(){
        qry="select * from movies";
        return jdbcTemplate.query(qry, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie theMovie =new Movie();
                theMovie.setMovieId(rs.getInt("movieid"));
                theMovie.setMovieName(rs.getString("moviename"));
                theMovie.setMovieDirector(rs.getString("moviedirector"));
                theMovie.setImdbRating(rs.getDouble("imdbrating"));
                return theMovie;
            }
        });
    }


    public Movie getMovieByIdFromRepository(Integer id) {
        qry="select * from movies where movieid= ?";
//        Movie theMovie= jdbcTemplate.queryForObject(qry, new Object[]{id}, Movie.class);
//        return theMovie;
        return  jdbcTemplate.queryForObject(qry, new Object[]{id},new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie theMovie =new Movie();
                theMovie.setMovieId(rs.getInt("movieid"));
                theMovie.setMovieName(rs.getString("moviename"));
                theMovie.setMovieDirector(rs.getString("moviedirector"));
                theMovie.setImdbRating(rs.getDouble("imdbrating"));
                return theMovie;
            }
        });
    }

    public Movie getMovieByNameFromRepository(String name){
        qry="select * from movies where moviename like ? ";
        return jdbcTemplate.queryForObject(qry, new Object[]{name}, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie theMovie =new Movie();
                theMovie.setMovieId(rs.getInt("movieid"));
                theMovie.setMovieName(rs.getString("moviename"));
                theMovie.setMovieDirector(rs.getString("moviedirector"));
                theMovie.setImdbRating(rs.getDouble("imdbrating"));
                return theMovie;
            }
        });
    }


    public void addNewMovieFromRepository(Movie theMovie){
        qry="insert into movies(movieid,moviename,moviedirector,imdbrating) values(?,?,?,?)";
        jdbcTemplate.update(qry,theMovie.getMovieId(),theMovie.getMovieName(),
                                theMovie.getMovieDirector(),theMovie.getImdbRating()
        );
    }

    public void updateMovieByIdFromRepository(Integer id,Movie movieUpdated) {
        qry ="update movies set moviename=?,moviedirector=?,imdbrating=? where movieid=?";
        jdbcTemplate.update(qry, movieUpdated.getMovieName(),movieUpdated.getMovieDirector(),
                                                    movieUpdated.getImdbRating(),movieUpdated.getMovieId());
    }

    public void deleteMovieByIdFromRepository(Integer id){
        qry="delete from movies where movieid=?";
        jdbcTemplate.update(qry,new Object[]{id});

    }
}

// {
//         "movieId": 1,
//         "movieName": "Avengers: Infinity War",
//         "movieDirector": "Russo Brothers",
//         "imdbRating": 8.4
//         },
//         {
//         "movieId": 2,
//         "movieName": "Avengers: End Game",
//         "movieDirector": "Russo Brothers",
//         "imdbRating": 8.7
//         },
//         {
//         "movieId": 3,
//         "movieName": "Inception",
//         "movieDirector": "Christopher Nolan",
//         "imdbRating": 8.9
//         },
//         {
//         "movieId": 4,
//         "movieName": "The Revenant",
//         "movieDirector": "Alexandro",
//         "imdbRating": 8.0
//         },
//         {
//         "movieId": 5,
//         "movieName": "Dunkirk",
//         "movieDirector": "Christopher Nolan",
//         "imdbRating": 8.5
//         }
