package com.user_services.user_services.repository;

import  com.user_services.user_services.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}