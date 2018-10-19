package com.xlx.rest.controller;

import com.xlx.rest.entity.User;
import com.xlx.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/mvc/user/save")
    public Boolean save(@RequestBody User user){
        return userRepository.save(user);
    }
}
