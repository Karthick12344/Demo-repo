package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

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


}
