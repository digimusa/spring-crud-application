package com.bongumusa.springcrudapplication.controller;

import com.bongumusa.springcrudapplication.model.User;
import com.bongumusa.springcrudapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    //Injecting user service class
    private final UserService userService;

    @PostMapping("/addUser")
    //method to add/create new user
    public User addUser(@RequestBody User user) {
        //returning method to add/create user from user service class
        return userService.createUser(user);
    }

    @PostMapping("/addUsers")
    //method to add/create new users
    public List<User> addUsers(@RequestBody List<User> users) {
        //returning method to add/create users from user service class
        return userService.createUsers(users);
    }

    @GetMapping("/getUser/{id}")
    //method to get user passing the id
    public User getUserById(@PathVariable int id) {
        //returning method to get user by id from user service class
        return userService.getUserById(id);
    }

    @GetMapping("/getUsers")
    //method to get all users
    public List<User> getAllUsers() {
        //returning method to get all users from user service class
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    //method to update user info
    public User updateUser(@RequestBody User user) {
        //returning method to update user info from user service class
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    //method to delete user passing the id
    public String deleteUser(@PathVariable int id) {
        //returning method to delete user by id from user service class
        return userService.deleteUserById(id);
    }
}
