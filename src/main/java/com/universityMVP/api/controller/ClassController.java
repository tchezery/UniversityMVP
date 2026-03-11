package com.universityMVP.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import com.universityMVP.api.repository.ClassRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.universityMVP.api.model.CourseClass;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController
{
    @Autowired
    private ClassRepository classRepository;

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