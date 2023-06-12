package com.bongumusa.springcrudapplication.service;

import com.bongumusa.springcrudapplication.exceptions.ResourceNotFoundException;
import com.bongumusa.springcrudapplication.model.User;
import com.bongumusa.springcrudapplication.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //Injecting an instance of user repository interface
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Bean
    //Method to encrypt password
    public PasswordEncoder passwordEncoder() {
        //returning BCrypt encoder method
        return new BCryptPasswordEncoder();
    }

    //Service method to create a single new user
    public User createUser(User user) {
        //Declaring and assigning hashed variable to password encoder method
        String hashedPassword = passwordEncoder().encode(user.getPassword());
        //setting password from User model to hashed password
        user.setPassword(hashedPassword);
        //returning a save method from JPA repository that takes in a users parameter
        return userRepo.save(user);
    }

    //Service method to create a new users
    public List<User> createUsers(List<User> users) {
        //User user = new User();
        //String hashedPassword = passwordEncoder().encode(user.getPassword());
        //user.setPassword(hashedPassword);
        //userRepo.save(user);
        //returning a saveAll method from JPA repository that takes in a users parameter
        return userRepo.saveAll(users);
    }

    //Service method to get a user by id
    public User getUserById(int id) {
        //returning a findByID method from JPA repository that takes in a id parameter
        return this.userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User ID: " + id + " is not found"));
    }

    //Service method to get all users
    public List<User> getUsers() {
        //returning a findAll method from JPA repository
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        User oldUser = null;
        Optional<User> optionalUser = Optional.ofNullable(userRepo.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User ID: " + user.getId() + " is not found")));
        if (optionalUser.isPresent()) {
            oldUser = optionalUser.get();
            oldUser.setFullname(user.getFullname());
            oldUser.setEmail(user.getEmail());
            oldUser.setPhone(user.getPhone());
            oldUser.setPassword(user.getPassword());
            oldUser.setRole(user.getRole());
            oldUser.setIsactive(user.isIsactive());
            oldUser.setPassword(passwordEncoder().encode(user.getPassword()));
            userRepo.save(oldUser);
        } else {
            return new User();
        }
        return oldUser;
    }

    //Service method to delete a user by id
    public String deleteUserById(int id) {
        //deleting user using deleteById method from JPA repository that takes in a id parameter
        userRepo.deleteById(id);
        //returning a message to confirm deletion
        return "User Deleted";
    }
}
