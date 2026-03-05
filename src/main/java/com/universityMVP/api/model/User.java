package com.universityMVP.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import jakarta.persistence.Column;

import com.universityMVP.api.model.Role;

//model == blueprint

// Entity with hibernate create table User automatically in database
@Entity
// Table database reference
// If not exist Hibernate create automatically
@Table(name = "users")
public class User 
{
    //Define the next attribute as the Primary Key
    @Id
    //Generate Primary Key value automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Key above @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    
    // Define the role attribute as an enumerated type and store it as a string in the database
    @Enumerated(EnumType.STRING)
    // Define the role attribute as not nullable in the database
    @Column(nullable = false)
    private Role role;

    // Getters and Setters of attributes
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}