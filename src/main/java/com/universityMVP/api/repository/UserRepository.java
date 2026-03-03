package com.universityMVP.api.repository;

import com.universityMVP.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Connection queries with database
@Repository
                                // Jpa Library imports more then 20 default methods automatically
                                // to manipulate DB
public interface UserRepository extends JpaRepository<User, Long> 
{
    
}