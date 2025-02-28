package com.FairShare.svc;

import com.FairShare.dto.UserRequest;
import com.FairShare.dto.UserResponse;
import com.FairShare.entity.User;
import com.FairShare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserResponse createUser(UserRequest user) {
        return null;
    }

    @Override
    public UserResponse getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}