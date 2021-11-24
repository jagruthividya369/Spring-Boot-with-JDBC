package com.example.demo.services;

import com.example.demo.entities.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> displayAllMoviesService(){

        return movieRepository.displayAllMoviesFromRepository();
    }


    public Movie getMovieByIdService(Integer id) {
        return movieRepository.getMovieByIdFromRepository(id);
    }

    public Movie getMovieByNameService(String name){
        return movieRepository.getMovieByNameFromRepository(name);
    }


    public void addNewMovieService(Movie theMovie){

        movieRepository.addNewMovieFromRepository(theMovie);
    }


    public void updateMovieByIdService(Integer id,Movie movieUpdated) {
         movieRepository.updateMovieByIdFromRepository(id, movieUpdated);
    }

    public void deleteMovieByIdService(Integer id){
        movieRepository.deleteMovieByIdFromRepository(id);
    }
}
