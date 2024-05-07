package com.user_services.user_services.model;

import jakarta.persistence.*;

@Entity
    @Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "patient_name")
        private String patientName;

        @Column(name = "phone_number")
        private Long phoneNumber;

        private String email;

        private String password;

        @Column(name = "role_id")
        private Long roleId;

        public User() {}

        public User(String patientName, Long phoneNumber, String email, String password, Long roleId) {
            this.patientName = patientName;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.password = password;
            this.roleId = roleId;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }
    }