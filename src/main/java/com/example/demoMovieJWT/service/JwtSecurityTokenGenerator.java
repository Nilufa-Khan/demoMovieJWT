package com.example.demoMovieJWT.service;

import com.example.demoMovieJWT.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtSecurityTokenGenerator implements SecurityTokenGenerate{
    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = null;

        jwtToken = Jwts.builder().setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"examplekey").compact();
        Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User Successfully logged in");
        return map;
    }
}
