package com.example.deployment_test.controller;

import com.example.deployment_test.dto.UserRequestDTO;
import com.example.deployment_test.model.User;
import com.example.deployment_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(path = "/create")
    public User createUser(@RequestBody UserRequestDTO userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());

        return userRepository.save(user);
    }




    @GetMapping(path = "/get/all")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/")
    public String deploymentConformation(){
        return "<b><h1>LOVE YOU JAN<h1></b>";
    }
}
