package com.user_services.user_services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user_services.user_services.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailOrPatientName(String email, String patientName);

    Optional<User> findByPatientName(String patientName);

    Boolean existsByPatientName(String patientName);

    Boolean existsByEmail(String email);

}

