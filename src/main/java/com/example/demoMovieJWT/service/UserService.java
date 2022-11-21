package com.example.demoMovieJWT.service;

import com.example.demoMovieJWT.domain.Movie;
import com.example.demoMovieJWT.domain.User;
import com.example.demoMovieJWT.exception.UserAlreadyExists;
import com.example.demoMovieJWT.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    User addUser(User user) throws UserAlreadyExists;
    User addMovieForUser(String email, Movie movie) throws UserNotFoundException;


}
