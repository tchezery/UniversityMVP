package com.universityMVP.api.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Course> findCourseByName (String name)
    {

        List<Course> courses = new ArrayList<>();

        String query = "SELECT * FROM course WHERE UPPER(name) LIKE UPPER(?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
            ) 
        {
            pstmt.setString(1, "%" + name + "%" );

            try (ResultSet rs = pstmt.executeQuery())
            {
                while (rs.next())
                {
                    Course course = new Course();
                    course.setId(rs.getLong("id"));
                    course.setName(rs.getString("name"));
                    courses.add(course);
                }
            }

            return courses;
        
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}