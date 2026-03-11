package com.universityMVP.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.universityMVP.api.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.universityMVP.api.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Endpoint and Connection Methods
@RestController
@RequestMapping("/peoples")
public class UserController
{
    // Instancie repository automatically
    // Dont need to use the "UserRepostory" in each method (post, get, etc)
    @Autowired
    private UserRepository userRepository;

    //body example:
    /*
        {
            "name": "John Doe",
            "email": "john.doe@example.com",
            "birthDate": "1990-01-01",
            "password": "password123",
            "role": "STUDENT"
        }
    */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        if (user.getName() == null || user.getEmail() == null || user.getBirthDate() == null || user.getPassword() == null || user.getRole() == null) 
        {
            return ResponseEntity.badRequest().body("All fields are required");
        }

        try 
        {
            User createdUser = userRepository.createGenericUser(user);
            return ResponseEntity.ok(createdUser);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred while creating the user");
        }
    }

    //example: http://localhost:8080/peoples/name?value=John
    @GetMapping("/name")
    public List<User> getUsersByName(@RequestParam("value") String name) 
    {
        return userRepository.findUsersByName(name);
    }

    //example: http://localhost:8080/peoples/age?value=20
    @GetMapping("/age")
    public List<User> getUsersByAge(@RequestParam("value") int age)
    {
        return userRepository.findUsersByAge(age);
    }

    //example: http://localhost:8080/peoples/page?page=0&size=10
    @GetMapping("/page")
    public ResponseEntity<?> getAllUsers(@RequestParam("page") int page, @RequestParam("size") int size)
    {
        if (size > 10 || size < 1) 
        {
            return ResponseEntity.badRequest().body("Size must be between 1 and 10");
        }

        List<User> users = userRepository.findAllUsers(page, size);

        String lastName = users.isEmpty() ? null : users.get(users.size() - 1).getName();

        return ResponseEntity.ok(new UserRepository.PaginatedUserResponse(users, lastName));
    }
}