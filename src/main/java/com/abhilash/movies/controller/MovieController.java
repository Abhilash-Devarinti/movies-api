package com.abhilash.movies.controller;

import com.abhilash.movies.model.Movie;
import com.abhilash.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<?> getSingleMovieByImdbId(@PathVariable String imdbId){
        Optional<Movie> movie = service.findByImdbId(imdbId);

        if(movie.isPresent()) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie Not Found");
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getTrailerLinkByTitle(@PathVariable String title) {
        Optional<Movie> movie = service.findByTitle(title);

        if (movie.isPresent()) {
            String trailerLink = movie.get().getTrailerLink();
            return ResponseEntity.ok(trailerLink);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveMovie(@RequestBody Movie movie) {
        service.saveMovie(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
