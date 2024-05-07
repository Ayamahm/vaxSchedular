package com.user_services.user_services.model;


import jakarta.persistence.*;

@Entity
@Table(name = "role")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "role_id")
    private Long roleId;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
        // Initialize roleId based on the role's name
        switch (name) {
            case "ROLE_ADMIN":
                this.roleId = 1L;
                break;
            case "ROLE_USER":
                this.roleId = 2L; // L FOR LONG DATATYPE
                break;
            case "ROLE_CENTER":
                this.roleId = 3L;
                break;
            default:
                this.roleId = 2L; // Default to patient role
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}