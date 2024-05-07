package com.appointments.appointments.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointments.appointments.model.Appointment;
import com.appointments.appointments.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private  AppointmentRepository appointmentRepo;


    //OCL => check date in future
    public Appointment saveAppointment(Appointment appointment) {
        // Get the current date
        Date currentDate = new Date();
        // Check if the appointment date is after the current date
        if (appointment.getDate().after(currentDate)) {
            // If the date is in the future, save the appointment
            return appointmentRepo.save(appointment);
        } else {
            // If the date is not in the future, throw an exception or handle accordingly
            throw new IllegalArgumentException("Appointment date must be in the future.");
        }
    }

    public List<Appointment> getAllPatients() {
        return appointmentRepo.findAll();
    }

    public String deletePatientID(Integer id)
    {
        Optional <Appointment> optional = appointmentRepo.findById(id);
        if(optional.isPresent())
        {
            appointmentRepo.deleteById(id);
            return "Your Reservation Request is rejected , try later!" ;
        }
        else
        {
            return " id not found";
        }
    }


    public Appointment findById(Integer id)
    {
        Optional <Appointment> optional = appointmentRepo.findById(id);
        Appointment appointment = null;
        if(optional.isPresent())
        {
            appointment=optional.get();
        }
        else
        {
            throw new RuntimeException("no found");
        }
        return appointment;

    }


    
    public Appointment updateApproved(Integer id, String approvedValue) {
        Optional<Appointment> optional = appointmentRepo.findById(id);
        if (optional.isPresent()) {
            Appointment existingAppointment = optional.get();
            existingAppointment.setApproved(Integer.valueOf(approvedValue)); // Update only the approved field
            
            return appointmentRepo.save(existingAppointment); // Save the updated appointment
        } else {
            return null; // or throw an exception
        }
    }
    



}
