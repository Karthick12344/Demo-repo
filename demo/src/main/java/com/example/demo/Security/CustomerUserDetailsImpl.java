package com.example.demo.Security;

import com.example.demo.Entity.TestUser;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomerUserDetailsImpl implements UserDetails {

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> roles;

    public CustomerUserDetailsImpl(TestUser user) {
        this.username = username;
        this.password = password;
        this.roles = user.getRoles().split(",").length==0 ? java.util.Collections.emptyList() :
                java.util.Arrays.stream(user.getRoles().split(","))
                        .map(role ->"ROLE_" + role)
                        .map(org.springframework.security.core.authority.SimpleGrantedAuthority::new)
                        .toList();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
