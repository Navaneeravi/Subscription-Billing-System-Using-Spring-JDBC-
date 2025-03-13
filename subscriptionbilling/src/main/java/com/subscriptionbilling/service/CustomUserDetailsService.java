package com.subscriptionbilling.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.subscriptionbilling.entity.User as CustomUser;
import com.subscriptionbilling.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	com.subscriptionbilling.entity.User customUser = userRepository.findByName(username);
        if (customUser == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Ensure roles are prefixed with ROLE_
        String role = customUser.getRole();
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }

        return User.builder()
                   .username(customUser.getName())
                   .password(customUser.getPassword()) // Password must be BCrypt encoded
                   .roles(role.replace("ROLE_", "")) // Spring Security expects role names without prefix
                   .build();
    }
}