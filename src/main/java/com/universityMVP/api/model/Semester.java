package com.universityMVP.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "semester")
public class Semester
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}