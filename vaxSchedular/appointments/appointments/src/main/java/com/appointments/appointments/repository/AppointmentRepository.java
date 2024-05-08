package com.appointments.appointments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointments.appointments.model.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
