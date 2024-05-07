package com.appointments.appointments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.appointments.model.Appointment;
import com.appointments.appointments.services.AppointmentService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class appointmentController {

    @Autowired
    public AppointmentService appointmentService ;

    @PostMapping("/appointments")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping("/getPatients")
    public List<Appointment> getAllCenters() {
        return appointmentService.getAllPatients();
    }

    @DeleteMapping("/{id}/deletepatient")
    public String deletePatient(@PathVariable Integer id)
    {
        return appointmentService.deletePatientID(id);
    }


    
    @GetMapping("/{id}/findPatient")
    public Appointment findPatient(@PathVariable Integer id)
    {
        return appointmentService.findById(id);
    }


    @PutMapping("/{id}/updateappointment")
    public Appointment updateappointment(@PathVariable Integer id, @RequestBody String approvedValue) {
        return appointmentService.updateApproved(id, approvedValue);
    }

}
