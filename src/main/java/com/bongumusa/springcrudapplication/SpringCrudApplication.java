package com.bongumusa.springcrudapplication;

import com.bongumusa.springcrudapplication.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import com.bongumusa.springcrudapplication.model.User;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringCrudApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCrudApplication.class, args);
	}

	CommandLineRunner run(UserRepo userRepo){
		return args -> {
			userRepo.save(new User(0,"Bongumusa Cele","bongumusa@gmail.com","0826698585","bongumusa@50","user",true));
		};
	}

}
