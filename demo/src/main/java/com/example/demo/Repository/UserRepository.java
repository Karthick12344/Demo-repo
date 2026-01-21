package com.example.demo.Repository;

import com.example.demo.Entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TestUser, Integer>

{
    TestUser findByUsername(String username);

}

