package com.example.demo.Service;

import com.example.demo.Entity.TestUser;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    private UserRepository userRepository; // Injects the DepartmentRepository dependency.

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TestUser saveUser(TestUser testUser) {
        // Saves and returns the department entity.

        String encodedPassword = passwordEncoder.encode(testUser.getPassword());
        testUser.setPassword(encodedPassword);

        return userRepository.save(testUser);

    }

}
