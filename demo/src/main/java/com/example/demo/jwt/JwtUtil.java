package com.example.demo.jwt;

import com.example.demo.Entity.TestUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

    @Component
    public class JwtUtil {


    //    AuthenticationManager authManager;

        private final String secret_key = "2b3d18193ddc47451e86a29e0bd1580ab5f4415f4778c74b507fbcd3463bf717";
        private final Key key = Keys.hmacShaKeyFor(secret_key.getBytes(StandardCharsets.UTF_8));

        public String generateToken(UserDetails userDetails) {
           //pass all the three section to generate the jwt token
            //if the user is valid only generate token otherwise throw message

          //  Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(testUser.getUsername(),testUser.getPassword()));
           // if (authentication.isAuthenticated()) {
                return Jwts.builder()
                        .setSubject(userDetails.getUsername())
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                        .signWith(key,SignatureAlgorithm.HS256)
                        .compact();
         //   } else {
          //      throw new RuntimeException();// show loginFailurePage
         //   }

        }

        public String getUserName(String token) {
            return extractClaims(token).getSubject();
        }

        private Claims extractClaims(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }

        public boolean validateToken(String token, UserDetails userDetails) {
            return userDetails.getUsername().equals(getUserName(token))
                    && !isTokenExpired(token);
        }

        private boolean isTokenExpired(String token) {
            return extractClaims(token)
                    .getExpiration()
                    .before(new Date());
        }

    }



