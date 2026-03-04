package com.universityMVP.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.universityMVP.api.model.User;

//Connection queries with database
@Repository
                                // Jpa Library imports more then 20 default methods automatically
                                // to manipulate DB
public interface UserRepository extends JpaRepository<User, Long> 
{   
}