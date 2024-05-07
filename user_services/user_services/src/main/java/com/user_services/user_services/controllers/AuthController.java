package com.user_services.user_services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_services.user_services.dto.LoginDto;
import com.user_services.user_services.dto.SignUpDto;
import com.user_services.user_services.model.Role;
import com.user_services.user_services.model.User;
import com.user_services.user_services.repository.RoleRepository;
import com.user_services.user_services.repository.UserRepository;
import com.user_services.user_services.service.CustomUserDetailsService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
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

    @Autowired 
    private CustomUserDetailsService service ;

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
            // If authentication fails, return an error response
            return new ResponseEntity<>("Invalid data", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {

        // Check if the email already exists
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // Find the role based on roleId
        Optional<Role> roleOptional = roleRepository.findById(signUpDto.getRoleId());
        Role role;
        if (roleOptional.isPresent()) {
            role = roleOptional.get();
        } else {
            // If the role is not found, return an error response
            return new ResponseEntity<>("Role not found!", HttpStatus.BAD_REQUEST);
        }

        // Create user object
        User user = new User();
        user.setPatientName(signUpDto.getPatientName());
        user.setPhoneNumber(signUpDto.getPhoneNumber());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRoleId(signUpDto.getRoleId());

        // Save the user
        userRepository.save(user);

        return new ResponseEntity<>("User signed up successfully", HttpStatus.OK);
    }


    
    @GetMapping("/getUsers")
    public List<User> getAllCenters() {
        return service.getAllusers();
    }

}
