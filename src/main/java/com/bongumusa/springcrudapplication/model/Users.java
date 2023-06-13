package com.bongumusa.springcrudapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String fullname;
    private String email;
    private String phone;
    private String password;
    private String role;
    private boolean isactive;
}
