package com.universityMVP.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import com.universityMVP.api.model.Discipline;
import com.universityMVP.api.model.Professor;
import com.universityMVP.api.model.Semester;

@Entity
@Table(name = "class")
public class Class
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_discipline")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "id_semester")
    private Semester semester;

    // Getters and Setters   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Discipline getDiscipline() { return discipline; }
    public void setDiscipline(Discipline discipline) { this.discipline = discipline; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    public Semester getSemester() { return semester; }
    public void setSemester(Semester semester) { this.semester = semester; }
}