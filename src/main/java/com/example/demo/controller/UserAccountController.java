package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    // ✅ Register a new user
    @PostMapping
    public UserAccount registerUser(@RequestBody UserAccount user) {
        return userAccountService.register(user);
    }

    // ✅ Get user by email
    @GetMapping("/{email}")
    public UserAccount getUserByEmail(@PathVariable String email) {
        return userAccountService.getByEmail(email);
    }
}
