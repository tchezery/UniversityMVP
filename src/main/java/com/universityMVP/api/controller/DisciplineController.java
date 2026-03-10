package com.universityMVP.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityMVP.api.repository.DisciplineRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.universityMVP.api.model.Discipline;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineController
{
    @Autowired
    private DisciplineRepository disciplineRepository;

    @PostMapping
    public Discipline saveDiscipline(@RequestBody Discipline discipline)
    {
        return disciplineRepository.save(discipline);
    }

    @GetMapping
    public List<Discipline> listDisciplines()
    {
        return disciplineRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteDiscipline(@PathVariable Long id)
    {
        disciplineRepository.deleteById(id);
    }
}