package com.abhilash.movies.repository;

import com.abhilash.movies.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
     Optional<User> findByUsername(String username);
}
