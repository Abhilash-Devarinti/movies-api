package com.abhilash.movies.controller;

import com.abhilash.movies.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody Map<String, String> payload) {
        reviewService.addReview(payload.get("reviewBody"), payload.get("imdbId"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
