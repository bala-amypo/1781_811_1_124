package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;

public class AuthController {

    private final UserAccountService service;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService service,
                          AuthenticationManager authManager,
                          JwtUtil jwtUtil) {
        this.service = service;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<JwtResponse> register(RegisterRequest req) {
        UserAccount u = new UserAccount();
        u.setEmail(req.getEmail());
        u.setFullName(req.getFullName());
        u.setPassword(req.getPassword());
        u.setRole(req.getRole());

        UserAccount saved = service.register(u);
        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<JwtResponse> login(LoginRequest req) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new UnauthorizedException("Invalid credentials");
        }

        UserAccount u = service.findByEmailOrThrow(req.getEmail());
        String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
