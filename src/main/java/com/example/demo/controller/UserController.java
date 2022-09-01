package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody User user, HttpSession session) throws UserAlreadyExistException {
        User user1 = userService.signUp(user);
        if (user1 != null) {
            session.setAttribute("user", user1);
            return new ResponseEntity<User>(user1, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(user1, HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user, HttpSession session) {
        User user_info = userService.signIn(user);
        if (user_info != null) {
            session.setAttribute("user", user_info);
            return new ResponseEntity<>(user_info, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
