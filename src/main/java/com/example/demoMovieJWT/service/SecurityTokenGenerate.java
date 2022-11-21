package com.example.demoMovieJWT.service;

import com.example.demoMovieJWT.domain.User;

import java.util.Map;

public interface SecurityTokenGenerate {
    Map<String,String> generateToken(User user);
}
