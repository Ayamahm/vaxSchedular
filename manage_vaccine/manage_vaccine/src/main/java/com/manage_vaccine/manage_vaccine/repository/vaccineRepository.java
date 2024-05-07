package com.manage_vaccine.manage_vaccine.repository;

import com.manage_vaccine.manage_vaccine.model.vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface vaccineRepository extends  JpaRepository<vaccine,Integer> {

}
