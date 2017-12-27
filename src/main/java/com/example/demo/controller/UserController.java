package com.example.demo.controller;

import com.example.demo.entity.User;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public User postUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public  String greeting() {

        return "login";
    }

}
