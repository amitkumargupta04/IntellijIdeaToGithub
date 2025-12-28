package com.example.Fitness.web.apps.controller;

import com.example.Fitness.web.apps.Dto.RegisterRequest;
import com.example.Fitness.web.apps.Dto.UserResponse;
import com.example.Fitness.web.apps.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(userService.register(registerRequest));
    }
}
