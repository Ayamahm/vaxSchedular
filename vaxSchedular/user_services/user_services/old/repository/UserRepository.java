package com.toka.again.repository;

import com.toka.again.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailOrPatientName(String email, String patientName);

    Optional<User> findByPatientName(String patientName);

    Boolean existsByPatientName(String patientName);

    Boolean existsByEmail(String email);

}

