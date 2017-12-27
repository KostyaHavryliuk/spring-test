package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User, Long> {

     User getUserByName(String name);

     @Query("select u from User u where u.name =:name")
     List<User> getUserByNamev(@Param("name") String name);
}
