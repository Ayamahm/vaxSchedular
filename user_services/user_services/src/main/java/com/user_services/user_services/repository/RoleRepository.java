package com.user_services.user_services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_services.user_services.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
