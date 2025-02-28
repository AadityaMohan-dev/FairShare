package com.FairShare.svc;

import com.FairShare.dto.UserRequest;
import com.FairShare.dto.UserResponse;
import com.FairShare.entity.User;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest user);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, UserRequest user);

    void deleteUser(Long id);
}