package com.example.demoMovieJWT.service;

import com.example.demoMovieJWT.domain.Movie;
import com.example.demoMovieJWT.domain.User;
import com.example.demoMovieJWT.exception.UserAlreadyExists;
import com.example.demoMovieJWT.exception.UserNotFoundException;
import com.example.demoMovieJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExists {
       if(userRepository.findById(user.getEmail()).isPresent()){
           throw new UserAlreadyExists();
       }
       return userRepository.insert(user);
    }

    @Override
    public User addMovieForUser(String email, Movie movie) throws UserNotFoundException {
      if(userRepository.findById(email).isEmpty()){
          throw new UserNotFoundException();
      }
      User user = userRepository.findByEmail(email);
      if(user.getMovieList() == null){
        user.setMovieList(Arrays.asList(movie));
      }else{
          List<Movie> movies = user.getMovieList();
          movies.add(movie);
          user.setMovieList(movies);
      }
      return userRepository.save(user);
    }


}
