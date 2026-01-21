package com.example.demo.Security;

import com.example.demo.controller.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
    Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder)
    {
        UserDetails userDetails = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123") )//{noop} indicates that no encoding is used
               // .password("$2a$12$oNdeGdK9zRr.91mimlAhJ.L7JwRVCTmVAdrEpZHBqc9UImD2jLXuW")
                .roles("ADMIN")
                .build();


        UserDetails userDetails1 = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user123"))
                .roles("USER")
                .build();


        return new InMemoryUserDetailsManager(userDetails,userDetails1){
         };
      //  return new CustomerUserDetailsServiceImpl();


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/welcome").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());


        return httpSecurity.build();
    }

}
