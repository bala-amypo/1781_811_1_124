package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    private final byte[] secret;
    private final long expiration;

    public JwtUtil(byte[] secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(Long userId, String email, String role) {
        String raw = userId + "|" + email + "|" + role;
        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    public String extractEmail(String token) {
        return decode(token)[1];
    }

    public String extractRole(String token) {
        return decode(token)[2];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(decode(token)[0]);
    }

    public boolean validateToken(String token) {
        try {
            decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String[] decode(String token) {
        return new String(Base64.getDecoder().decode(token)).split("\\|");
    }
}
