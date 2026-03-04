package com.universityMVP.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.universityMVP.api.model.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long>
{
}