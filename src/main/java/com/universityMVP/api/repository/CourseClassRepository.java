package com.universityMVP.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universityMVP.api.model.CourseClass;

@Repository
public interface CourseClassRepository extends JpaRepository<CourseClass, Long>
{
}