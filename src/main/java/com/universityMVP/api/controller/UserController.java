package com.universityMVP.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import com.universityMVP.api.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.universityMVP.api.model.User;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//Endpoint and Connection Methods
@RestController
@RequestMapping("/users")
public class UserController
{
    // Instancie repository automatically
    // Dont need to use the "UserRepostory" in each method (post, get, etc)
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User saveUser(@RequestBody User user)
    {
        // The save method was created by hibernate
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> listUsers()
    {
        return userRepository.findAll();
    }
}