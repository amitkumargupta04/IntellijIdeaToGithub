package com.example.Fitness.web.apps.service;

import com.example.Fitness.web.apps.Dto.RegisterRequest;
import com.example.Fitness.web.apps.Dto.UserResponse;
import com.example.Fitness.web.apps.model.User;
import com.example.Fitness.web.apps.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse register(RegisterRequest request) {

        // 1️⃣ Create User
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // 🔐 later bcrypt
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        // 2️⃣ Save to DB
        User savedUser = userRepository.save(user);

        // 3️⃣ Map to Response
        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        return response;
    }
}
