package com.manage_vaccine.manage_vaccine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccine")
public class vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id")
    private Integer vaccineID;

    @Column(name = "vaccine_name")
    private String vaccineName;

    @Column(name = "precautions")
    private String precautions;

    @Column(name = "center_name")
    private String centerName;

    @Column(name = "does")
    private String doesNumber;


    @Column(name = "timee")
    private String time;


    public Integer getVaccineId() {
        return vaccineID;
    }


    public void setVaccineId(Integer vaccineId) {
        this.vaccineID = vaccineId;
    }


    public String getVaccineName() {
        return vaccineName;
    }


    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }


    public String getPrecautions() {
        return precautions;
    }


    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }


    public String getCenterName() {
        return centerName;
    }


    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }


    public String getdoesNumber() {
        return doesNumber;
    }


    public void setdoesNumber(String doesNumber) {
        this.doesNumber = doesNumber;
    }


    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }
    

   

}
