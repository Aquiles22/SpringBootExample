package com.pagatodo.test.ws.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagatodo.test.dao.User;
import com.pagatodo.test.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return registeredUser;
    }

}