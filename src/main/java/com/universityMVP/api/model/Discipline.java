package com.universityMVP.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.universityMVP.api.model.Course;

@Entity
@Table(name = "discipline")
public class Discipline 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Many disciplines can be associated with one course
    @ManyToOne
    // Here we use JoinColumn because is foreign key of other table
    @JoinColumn(name = "id_course")
    // Always refer the class, not the ID. 
    // The JPA will handle the relationship and the foreign key automatically.
    private Course course;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}