package com.universityMVP.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universityMVP.api.model.CourseClass;
import com.universityMVP.api.repository.CourseClassRepository;

@RestController
@RequestMapping("/class")
public class CourseClassController
{
    @Autowired
    private CourseClassRepository classRepository;

    @PostMapping
    public CourseClass saveClass(@RequestBody CourseClass courseClass)
    {
        return classRepository.save(courseClass);
    }

    @GetMapping
    public List<CourseClass> listClasses()
    {
        return classRepository.findAll();
    }
}