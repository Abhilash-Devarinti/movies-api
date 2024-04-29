package com.abhilash.movies.service;

import com.abhilash.movies.model.Movie;
import com.abhilash.movies.repository.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepo movieRepo;


    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<Movie> findAllMovies(){
        return movieRepo.findAll();
    }

    public Optional<Movie> findByTitle(String title) {
        return movieRepo.findByTitle(title);
    }
}
