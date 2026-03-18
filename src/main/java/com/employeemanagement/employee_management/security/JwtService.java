package com.employeemanagement.employee_management.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // 🔐 Secret key (keep long)
    private static final String SECRET = "mysecretkeymysecretkeymysecretkey12345";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // ⏳ Token validity (1 day)
    private static final long EXPIRATION = 1000 * 60 * 60 * 24;

    // 🔥 1. Generate Token
    public String generateToken(Long employeeId, String role) {
        return Jwts.builder()
                .setSubject(String.valueOf(employeeId)) // user id
                .claim("role", role) // custom field
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔥 2. Extract Employee ID
    public Long extractEmployeeId(String token) {
        return Long.parseLong(getClaims(token).getSubject());
    }

    // 🔥 3. Extract Role
    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // 🔥 4. Validate Token
    public boolean isValid(String token) {
        try {
            getClaims(token); // throws error if invalid
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 🔍 Internal method
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}