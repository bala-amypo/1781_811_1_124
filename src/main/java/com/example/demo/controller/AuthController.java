package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;

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
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setRole(req.getRole());

        UserAccount saved = service.register(u);
        return ResponseEntity.ok(
                new JwtResponse(jwtUtil.generateToken(
                        saved.getId(), saved.getEmail(), saved.getRole()))
        );
    }

    public ResponseEntity<JwtResponse> login(LoginRequest req) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getEmail(), req.getPassword()));
        } catch (BadCredentialsException e) {
            throw new UnauthorizedException("Invalid credentials");
        }

        UserAccount u = service.findByEmailOrThrow(req.getEmail());
        return ResponseEntity.ok(
                new JwtResponse(jwtUtil.generateToken(
                        u.getId(), u.getEmail(), u.getRole()))
        );
    }
}
