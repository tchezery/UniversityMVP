package com.universityMVP.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    // Getters and Setters of attributes
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}