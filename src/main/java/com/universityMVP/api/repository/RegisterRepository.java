package com.universityMVP.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universityMVP.api.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> 
{
}