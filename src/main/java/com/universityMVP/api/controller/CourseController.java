package com.universityMVP.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import com.universityMVP.api.repository.CourseRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.universityMVP.api.model.Course;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }
}