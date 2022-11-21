package com.example.demoMovieJWT.controller;

import com.example.demoMovieJWT.domain.Movie;
import com.example.demoMovieJWT.domain.User;
import com.example.demoMovieJWT.exception.UserAlreadyExists;
import com.example.demoMovieJWT.exception.UserNotFoundException;
import com.example.demoMovieJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class UserController {
    UserService userService;



    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;

    }


    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExists {
        try{
            user.setMovieList(new ArrayList<>());
            return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
        }catch (Exception e){
            throw  new UserAlreadyExists();
        }
    }

    @PutMapping("/addMovie/{email}")
    public ResponseEntity<?> addMovies(@PathVariable String email,@RequestBody Movie movie) throws UserNotFoundException {
        try{
            return new ResponseEntity<>(userService.addMovieForUser(email,movie),HttpStatus.OK);
        }catch (Exception e){
            throw new UserNotFoundException();
        }

    }


}
