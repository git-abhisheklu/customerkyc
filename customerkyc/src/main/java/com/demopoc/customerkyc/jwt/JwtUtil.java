package com.demopoc.customerkyc.jwt;

import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.Base64;

@Component
public class JwtUtil {

    private static int getRandom() {
        int random = (int) Math.round(Math.random() * 1000000000);
        return random;
    }

    private static long getTimestamp() {
        long timestamp = Instant.now().getEpochSecond();
        return timestamp;
    }

    public static String generateToken() {
        int random = getRandom();
        long timestamp = getTimestamp();
        String rawSecret = "UTA5U1VEQXdNREF4VFZSSmVrNUVWVEpPZWxVd1RuYzlQUT09";
        String secretKey = Base64.getEncoder().encodeToString(rawSecret.getBytes());
        String token = io.jsonwebtoken.Jwts.builder()
                .setIssuer("PSPRINT")
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("iss", "PSPRINT")
                .claim("timestamp", timestamp)
                .claim("partnerId", "CORP00001")
                .claim("product", "WALLET")
                .claim("reqid", random)
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;

    }
}

