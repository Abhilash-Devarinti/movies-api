package com.abhilash.movies.controller;

import com.abhilash.movies.model.Movie;
import com.abhilash.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
       return new ResponseEntity<>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getSingleMovieByTitle(@PathVariable String title) {
        Optional<Movie> movie = service.findByTitle(title);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
    }
}
