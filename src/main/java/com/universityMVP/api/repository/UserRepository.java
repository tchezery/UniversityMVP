package com.universityMVP.api.repository;

import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;

import java.util.List;
import com.universityMVP.api.model.User;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.universityMVP.api.model.Role;


@Repository
public class UserRepository
{
    @Autowired
    private DataSource dataSource;

    public User createGenericUser(User user)
    {
        String query = "INSERT INTO user (name, email, birth_date, password, role) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setDate(3, java.sql.Date.valueOf(user.getBirthDate()));
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getRole().name());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) 
            {
                try (ResultSet rs = pstmt.getGeneratedKeys()) 
                {
                    if (rs.next()) 
                    {
                        user.setId(rs.getLong(1));
                    }
                }
            }
            
            return user;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findUsersByName(String name) 
    {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user WHERE UPPER(name) LIKE UPPER(?)";

        try (Connection conn = dataSource.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setString(1, "%" + name + "%");

            try (ResultSet rs = pstmt.executeQuery())
            {
                while (rs.next()) 
                {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    users.add(user);
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
            return users;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> findUsersByAge(int age)
    {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user " +
                                "WHERE (strftime('%Y', 'now') - strftime('%Y', birth_date/ 1000, 'unixepoch')) - " +
                                "(strftime('%m-%d', 'now') < strftime('%m-%d', birth_date/ 1000, 'unixepoch')) = ?";

        try (Connection conn = dataSource.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setInt(1, age);

            try (ResultSet rs = pstmt.executeQuery())
            {
                while (rs.next()) 
                {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setBirthDate(rs.getDate("birth_date").toLocalDate());
                    users.add(user);
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
            return users;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return users;
    }


    // Pagination class storage lastName
    public static class PaginatedUserResponse 
    {
        private List<User> users;
        private String lastName;

        public PaginatedUserResponse(List<User> users, String lastName) 
        {
            this.users = users;
            this.lastName = lastName;
        }

        public List<User> getUsers() { return users; }
        public String getLastName() { return lastName; }
    }

   public List<User> findAllUsers(int page, int size) 
   {
        List<User> users = new ArrayList<>();
        int offset = (page - 1) * size;

        String query = "SELECT * FROM user ORDER BY name ASC LIMIT ? OFFSET ?";

        try (Connection conn = dataSource.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setInt(1, size);
            pstmt.setInt(2, offset);

            try (ResultSet rs = pstmt.executeQuery())
            {
                while (rs.next()) 
                {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setBirthDate(rs.getDate("birth_date").toLocalDate());
                    user.setRole(Role.valueOf(rs.getString("role")));
                    users.add(user);
                }
            }
            
            return users;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return users;
    }
}