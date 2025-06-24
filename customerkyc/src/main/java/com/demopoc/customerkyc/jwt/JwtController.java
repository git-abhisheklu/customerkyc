package com.demopoc.customerkyc.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/generate")
    public ResponseEntity<String> generateToken() {
        return ResponseEntity.ok(jwtService.getToken());
    }
}