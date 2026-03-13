package com.universityMVP.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universityMVP.api.model.Course;
import com.universityMVP.api.repository.CourseRepository;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Course createCourse(@RequestBody Course course) 
    {
        return courseRepository.createCourse(course);
    }

    @GetMapping("/name")
    public List<Course> getCourseByName(@RequestParam("value") String name)
    {
        return courseRepository.findCourseByName(name);
    }
}