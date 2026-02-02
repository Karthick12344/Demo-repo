package com.example.demo.controller;

import com.example.demo.Entity.TestUser;
import com.example.demo.Security.CustomerUserDetailsServiceImpl;
import com.example.demo.Service.TestUserServiceImpl;
import com.example.demo.jwt.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private TestUserServiceImpl testUserService;

    @Autowired
    private CustomerUserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final CustomerUserDetailsServiceImpl customerUserDetailsServiceImpl;
    private final JwtUtil jwtUtil;


    public MainController(CustomerUserDetailsServiceImpl customerUserDetailsServiceImpl,
                            JwtUtil jwtUtil) {
        this.customerUserDetailsServiceImpl = customerUserDetailsServiceImpl;
        this.jwtUtil = jwtUtil;
    }

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

    @PostMapping("/token")
    public String generateToken(@RequestBody TestUser testUser) {
        logger.info("Controller class");
        UserDetails userDetails = userDetailsService.loadUserByUsername(testUser.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        return jwt;
    }

    @PostMapping ("/login")
    public ResponseEntity<?> createjwtUser(@RequestBody TestUser testUser) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        testUser.getUsername(),
                        testUser.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {

          //  UserDetails userDetails = customerUserDetailsServiceImpl.loadUserByUsername(testUser.getUsername());

           // String jwt = jwtUtil.generateToken(userDetails);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(Map.of("token", jwt));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
