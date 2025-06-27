package com.demopoc.customerkyc.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.Base64;

@Slf4j
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
        int random = 123;//getRandom();
        long timestamp = getTimestamp();
        log.info("random {}",random);
        log.info("timestamp {}",timestamp);
        String rawSecret = "UTA5U1VEQXdNREF4VFZSSmVrNUVWVEpPZWxVd1RuYzlQUT09";
        String secretKey = Base64.getEncoder().encodeToString(rawSecret.getBytes());
        String token = io.jsonwebtoken.Jwts.builder()
                .claim("timestamp", timestamp)
                .claim("partnerId", "CORP00001")
                .claim("reqid", random)
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;

    }
}

