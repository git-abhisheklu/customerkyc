package com.demopoc.customerkyc.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.partnerId}")
    private String partnerId;

    public String generateToken() {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        int random = (int) Math.round(Math.random() * 1_000_000_000);
        long timestamp = Instant.now().getEpochSecond();

        return Jwts.builder()
                .setSubject("TokenGeneration")
                .setHeaderParam("typ", "JWT")
                .claim("timestamp", timestamp)
                .claim("partnerId", partnerId)
                .claim("product", "WALLET")
                .claim("reqid", random)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}

