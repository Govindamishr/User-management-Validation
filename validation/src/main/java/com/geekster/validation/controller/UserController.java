package com.geekster.validation.controller;

import com.geekster.validation.model.User;
import com.geekster.validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")

    public String addUsers(@Valid @RequestBody User user){
        userService.addUser(user);
        return "added successfully";
    }
    @GetMapping("/users")

    public List<User> getAll() {
        return userService.getAllUsers();

    }

    @GetMapping("/users/{userId}")
    public User getById(@PathVariable int userId){


        return userService.getUserById(userId);

    }
    // put request

    @PutMapping("/users/{userId}")
    public String updateUserInfo(@PathVariable int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    // delete request

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return userService.deleteUserById(userId);
    }

}

