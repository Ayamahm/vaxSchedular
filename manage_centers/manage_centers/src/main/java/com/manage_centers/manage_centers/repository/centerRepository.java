package com.manage_centers.manage_centers.repository;

import com.manage_centers.manage_centers.model.vaccine_center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface centerRepository extends JpaRepository<vaccine_center,Integer> {

}
