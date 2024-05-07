package com.user_services.user_services.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user_services.user_services.model.User;
import com.user_services.user_services.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String patientNameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrPatientName(patientNameOrEmail, patientNameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: " + patientNameOrEmail));

        // Create a set of authorities based on the user's roleId
        Set<GrantedAuthority> authorities = Collections.singleton(getAuthority(user.getRoleId()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                authorities);
    }

    // Helper method to convert roleId to authority
    private GrantedAuthority getAuthority(Long roleId) {
        String roleName;
        switch (roleId.intValue()) {
            case 1:
                roleName = "ROLE_ADMIN";
                break;
            case 2:
                roleName = "ROLE_USER"; // Assuming roleId 2 represents a patient
                break;
            case 3:
                roleName = "ROLE_CENTER";
                break;
            default:
                roleName = "ROLE_USER"; // Default to user role
        }
        return new SimpleGrantedAuthority(roleName);
    }

        public List<User> getAllusers() {
        return userRepository.findAll();
    }

}