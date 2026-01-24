package com.example.demo.Security;

import com.example.demo.Entity.TestUser;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         TestUser user= userRepository.findByUsername(username);

         //Convert entity to Userdetail, converting one data type to another type

         UserDetails userDetails = new CustomerUserDetailsImpl(user);
                return userDetails;

    }

}
