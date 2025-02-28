package com.FairShare.svc;

import com.FairShare.dto.UserRequest;
import com.FairShare.dto.UserResponse;
import com.FairShare.entity.User;
import com.FairShare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // Create a new User entity from the request
        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .createdAt(LocalDateTime.now())
                .build();

        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Build and return the response
        return UserResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }

    @Override
    public UserResponse getUserById(Long id) {
        // Fetch the user from the database
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Build and return the response
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        // Fetch all users from the database
        List<User> users = userRepository.findAll();

        // Map each user to a UserResponse
        return users.stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .createdAt(user.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        // Fetch the existing user from the database
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update the user details
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword()); // In a real application, hash the password

        // Save the updated user to the database
        User updatedUser = userRepository.save(user);

        // Build and return the response
        return UserResponse.builder()
                .id(updatedUser.getId())
                .username(updatedUser.getUsername())
                .email(updatedUser.getEmail())
                .createdAt(updatedUser.getCreatedAt())
                .build();
    }

    @Override
    public void deleteUser(Long id) {
        // Check if the user exists
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }

        // Delete the user
        userRepository.deleteById(id);
    }
}