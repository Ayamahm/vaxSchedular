package com.appointments.appointments.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="appointment")
public class Appointment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "patient-name")
    private String patientName;
    @Column(name = "phone-number")
    private Long phoneNumber;
    @Column(name = "gender")
    private String gender;
    @Column(name = "city")
    private String city;
    @Column(name = "available-centers")
    private String availableCenters;
    @Column(name = "date")
    private Date date;
    @Column(name = "dose_number")
    private Long doseNumber;
    @Column(name = "vaccine")
    private String vaccine;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "approved")
    private Integer approved = 0 ;

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvailableCenters() {
        return availableCenters;
    }

    public void setAvailableCenters(String availableCenters) {
        this.availableCenters = availableCenters;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(Long doseNumber) {
        this.doseNumber = doseNumber;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

}
