package com.manage_centers.manage_centers.Dto;


public class VaccineCenterDTO {
    private String centerName;
    private String vaccineType;
    private String address;


    public String getCenterName() {
        return this.centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getVaccineType() {
        return this.vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
