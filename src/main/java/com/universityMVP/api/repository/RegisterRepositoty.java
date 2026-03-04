package com.universityMVP.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.universityMVP.api.model.Discipline;

@Repository
public interface RegisterRepositoty extends JpaRepository<Discipline, Long> 
{
}