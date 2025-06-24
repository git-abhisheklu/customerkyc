package com.demopoc.customerkyc.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private JwtUtil jwtUtil;

    public String getToken() {
        return jwtUtil.generateToken();
    }
}