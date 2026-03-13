package com.universityMVP.api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.universityMVP.api.model.Course;

@Repository
public class CourseRepository {

    @Autowired
    private DataSource dataSource;

    
    public Course createCourse (Course course) {
        
        String query = "INSERT INTO course (name) VALUES (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
            ) 
        {
            
            pstmt.setString(1, course.getName());

            pstmt.executeUpdate();

            return course;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}