package com.example.demo.controller;

import com.example.demo.Entity.TestUser;
import com.example.demo.Service.TestUserService;
import com.example.demo.Service.TestUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private TestUserServiceImpl testUserService;

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/welcome")
    public String welcome()
    {
        return "Welcome to Security Application";
    }

    @GetMapping("/thankyou")
    public String thankyou()
    {
        return "Welcome to thank you Application";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin()
    {
        return "Welcome to admin";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String user()
    {
        return "Welcome to user";
    }

    @PostMapping("/adduser")
    public TestUser saveUser(@RequestBody TestUser testUser) {
        logger.info("Controller class");
        return testUserService.saveUser(testUser);
    }

}
