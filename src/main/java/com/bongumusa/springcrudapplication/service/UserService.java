package com.bongumusa.springcrudapplication.service;

import com.bongumusa.springcrudapplication.model.User;
import com.bongumusa.springcrudapplication.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    //Injecting an instance of user repository interface
    private final UserRepo userRepo;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Service method to create a single new user
    public User createUser(User user) {
        //return a save method from JPA repository that takes in a users parameter
        String hashedPassword = passwordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepo.save(user);
    }

    //Service method to create a new users
    public List<User> createUsers(List<User> users) {
        //User user = new User();
        //return a saveAll method from JPA repository that takes in a users parameter
        //String hashedPassword = passwordEncoder().encode(user.getPassword());
        //user.setPassword(hashedPassword);
        //userRepo.save(user);
        return userRepo.saveAll(users);
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        User oldUser = null;
        Optional<User> optionalUser = userRepo.findById(user.getId());
        if (optionalUser.isPresent()) {
            oldUser = optionalUser.get();
            oldUser.setFullname(user.getFullname());
            oldUser.setEmail(user.getEmail());
            oldUser.setPhone(user.getPhone());
            oldUser.setPassword(user.getPassword());
            oldUser.setRole(user.getRole());
            oldUser.setIsactive(user.isIsactive());
            userRepo.save(oldUser);
        } else {
            return new User();
        }
        return oldUser;
    }

    public String deleteUserById(int id) {
        userRepo.deleteById(id);
        return "User Deleted";
    }
}
