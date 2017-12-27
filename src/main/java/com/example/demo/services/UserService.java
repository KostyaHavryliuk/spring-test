package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("Hello World");
        userRepository.save(user);
    }

    @Autowired
    private UserRepository userRepository;


    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) throws Exception {

        if (Objects.nonNull(userRepository.getUserByName(user.getName())))
            throw new Exception(String.format("User with name: %s already exist", user.getName()));
//      User user2 =   Optional.ofNullable(userRepository.getUserByName(user.getName()))
//                       .orElseThrow(() -> new Exception(String.format("User with name: %s already exist", user.getName())));

        return userRepository.save(user);
    }
}
