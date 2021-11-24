package com.example.demo.controllers;

import com.example.demo.entities.Movie;
import com.example.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class movieController {
    @Autowired
    MovieService movieService;

    //Display All Movies
    @GetMapping("/movies")
    public List<Movie>  displayAllMovies(){

        return movieService.displayAllMoviesService();
    }

    //Display Movie by Id
    @GetMapping("movies/id/{id}")
    public Movie getMovieById(@PathVariable Integer id){
        return movieService.getMovieByIdService(id);
    }
    //Display Movie by Name
    @GetMapping("movies/name/{name}")
    public Movie getMovieByName(@PathVariable String name){
        return movieService.getMovieByNameService(name);
    }

    //Add New Movies
    @PostMapping("/movies")
    public void addNewMovie(@RequestBody Movie theMovie){

        movieService.addNewMovieService(theMovie);
    }

    //Update Movie by id
    @PutMapping("/movies/{id}")
    public void updateMovieById(@PathVariable Integer id, @RequestBody Movie movieUpdated) {
         movieService.updateMovieByIdService(id, movieUpdated);
    }
    @DeleteMapping("/movies/{id}")
    public void deleteMovieById(@PathVariable Integer id){
        movieService.deleteMovieByIdService(id);
    }
}
