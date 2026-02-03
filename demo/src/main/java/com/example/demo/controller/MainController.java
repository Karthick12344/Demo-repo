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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/demo")
public class MainController {

   // Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private TestUserServiceImpl testUserService;

    @Autowired
    private CustomerUserDetailsServiceImpl userDetailsService;

    @Autowired
   // private AuthenticationManager authenticationManager;

   // private final CustomerUserDetailsServiceImpl customerUserDetailsServiceImpl;
   // private final JwtUtil jwtUtil;


  /*  public MainController(CustomerUserDetailsServiceImpl customerUserDetailsServiceImpl,
                            JwtUtil jwtUtil) {
        this.customerUserDetailsServiceImpl = customerUserDetailsServiceImpl;
        this.jwtUtil = jwtUtil;
    }*/


    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final TestUserServiceImpl userService;

    public MainController(AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil,
                          TestUserServiceImpl userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }


    @GetMapping("/public-check")
    public String publicCheck() {
        return "No JWT needed";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String user() {
        return "USER access success";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "ADMIN access success";
    }


    @PostMapping("/adduser")
    public TestUser addUser(@RequestBody TestUser user) {
        return userService.saveUser(user);
    }


    @PostMapping("/token")
    public String generateToken(@RequestBody TestUser testUser) {
        //logger.info("Controller class");
        UserDetails userDetails = userDetailsService.loadUserByUsername(testUser.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        return jwt;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody TestUser user) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(Map.of("token", token));
    }







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
/*
    @PostMapping("/adduser")
    public TestUser saveUser(@RequestBody TestUser testUser) {
        //logger.info("Controller class");
        return testUserService.saveUser(testUser);
    }
*/

}
