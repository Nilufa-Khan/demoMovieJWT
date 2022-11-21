package com.example.demoMovieJWT.repository;

import com.example.demoMovieJWT.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);

}
