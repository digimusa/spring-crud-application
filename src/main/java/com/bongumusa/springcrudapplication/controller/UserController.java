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
        //return method to add/create user from user service class
        return userService.createUser(user);
    }

    @PostMapping("/addUsers")
    //method to add/create new users
    public List<User> addUsers(@RequestBody List<User> users) {
        //return method to add/create users from user service class
        return userService.createUsers(users);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@RequestBody int id){
        return userService.deleteUserById(id);
    }

}
