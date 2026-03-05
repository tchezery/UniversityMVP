package com.universityMVP.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import com.universityMVP.api.repository.RegisterRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.universityMVP.api.model.Register;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterRepository registerRepository;

    @PostMapping
    public Register saveRegister(@RequestBody Register register)
    {
        return registerRepository.save(register);
    }

    @GetMapping
    public List<Register> listRegisters()
    {
        return registerRepository.findAll();
    }
}