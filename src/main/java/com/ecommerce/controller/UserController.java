package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
        
	@Autowired
    private UserRepository userRepository;

    // Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
    	System.out.println(user);
    	return userRepository.save(user);
    }

    // Login
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser == null) {
            throw new RuntimeException("EMAIL NOT FOUND");
        }

        if (!existingUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("WRONG PASSWORD");
        }

        return existingUser; // ✅ correct
    }
}
