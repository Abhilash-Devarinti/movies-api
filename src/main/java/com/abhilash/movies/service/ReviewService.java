package com.abhilash.movies.service;

import com.abhilash.movies.model.Movie;
import com.abhilash.movies.model.Review;
import com.abhilash.movies.repository.ReviewRepo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;
    private final MongoTemplate mongoTemplate;

    public ReviewService(ReviewRepo reviewRepo, MongoTemplate mongoTemplate) {
        this.reviewRepo = reviewRepo;
        this.mongoTemplate = mongoTemplate;
    }

    public void addReview(String reviewBody, String imdbId) {
        Review review = new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now());
        review = reviewRepo.save(review);

        Update update = new Update().addToSet("reviews", review);
        mongoTemplate.updateFirst(Query.query(Criteria.where("imdbId").is(imdbId)), update, Movie.class);
    }
}
