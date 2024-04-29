package com.abhilash.movies.controller;

import com.abhilash.movies.model.Movie;
import com.abhilash.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
       return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }
}
