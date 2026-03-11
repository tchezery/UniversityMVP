package com.universityMVP.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import com.universityMVP.api.model.CourseClass;

import java.util.Date;

@Entity
@Table(name = "activities")
public class Activities 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_course_class")
    private CourseClass courseClass;

    private String description;
    private Date activity_due_date;
    private float max_value;
}
