package com.bongumusa.springcrudapplication;

import com.bongumusa.springcrudapplication.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import com.bongumusa.springcrudapplication.model.Users;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringCrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCrudApplication.class, args);
	}

}
