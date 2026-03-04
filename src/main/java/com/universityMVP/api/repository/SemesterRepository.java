package com.universityMVP.api.repository;

import com.universityMVP.api.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Discipline, Long> 
{
}