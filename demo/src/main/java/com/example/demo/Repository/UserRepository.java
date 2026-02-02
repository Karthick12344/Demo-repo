package com.example.demo.Repository;

import com.example.demo.Entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public interface UserRepository extends JpaRepository<TestUser, Integer>

{

    TestUser findByUsername(String username);

    //TestUser saveUser(TestUser testUser);
}

