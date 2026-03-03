package com.universityMVP.api.controller;

import com.universityMVP.api.model.User;
import com.universityMVP.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Endpoint and Connection Methods
@RestController
@RequestMapping("/users")
public class UserController
{
    // Instancie repository automatically
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