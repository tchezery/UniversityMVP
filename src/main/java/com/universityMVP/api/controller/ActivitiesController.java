package com.universityMVP.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import com.universityMVP.api.repository.ActivitiesRepository;
import com.universityMVP.api.model.Activities;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {
    @Autowired
    private ActivitiesRepository activitiesRepository;

    @PostMapping
    public Activities saveActivity(@RequestBody Activities activity) {
        return activitiesRepository.save(activity);
    }

    @GetMapping
    public List<Activities> listActivities() {
        return activitiesRepository.findAll();
    }
}