package com.universityMVP.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import com.universityMVP.api.repository.SemesterRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.universityMVP.api.model.Semester;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/semesters")
public class SemesterController
{
    @Autowired
    private SemesterRepository semesterRepository;

    @PostMapping
    public Semester saveSemester(@RequestBody Semester semester)
    {
        return semesterRepository.save(semester);
    }

    @GetMapping
    public List<Semester> listSemesters()
    {
        return semesterRepository.findAll();
    }
}