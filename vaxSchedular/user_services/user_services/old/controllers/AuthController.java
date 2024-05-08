package com.user_services.user_services.controllers;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user_services.user_services.dto.LoginDto;
import  com.user_services.user_services.dto.SignUpDto;
import com.user_services.user_services.model.Role;
import com.user_services.user_services.model.User;
import  com.user_services.user_services.repository.RoleRepository;
import com.user_services.user_services.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        try {
            // Authenticate the user by email
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

            // Set the authenticated user in the security context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // If authentication is successful, return a success response
            return new ResponseEntity<>("User logged in successfully!", HttpStatus.OK);
        } catch (AuthenticationException e) {
            try {
                // If authentication by email fails, try authenticating by username
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

                // Set the authenticated user in the security context
                SecurityContextHolder.getContext().setAuthentication(authentication);

                // If authentication is successful, return a success response
                return new ResponseEntity<>("User logged in successfully!", HttpStatus.OK);
            } catch (AuthenticationException ex) {
                // If both username and email authentication fail, return an error response
                return new ResponseEntity<>("Invalid data", HttpStatus.UNAUTHORIZED);
            }
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
        // Check if the username already exists
        if (userRepository.existsByPatientName(signUpDto.getPatientName())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // Check if the email already exists
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // Create user object
        User user = new User();
        user.setPatientName(signUpDto.getPatientName());
        user.setPhoneNumber(signUpDto.getPhoneNumber());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        // Find the ROLE_ADMIN role
        Optional<Role> adminRoleOptional = roleRepository.findByName("ROLE_ADMIN");
        if (adminRoleOptional.isPresent()) {
            Role adminRole = adminRoleOptional.get();
            user.setRoles(Collections.singleton(adminRole));
        } else {
            // If the admin role is not found, create a default role
            Role defaultRole = new Role("ROLE_USER");
            roleRepository.save(defaultRole);
            user.setRoles(Collections.singleton(defaultRole));
        }

        // Save the user
        userRepository.save(user);

        return new ResponseEntity<>("User signed up successfully", HttpStatus.OK);
    }}
