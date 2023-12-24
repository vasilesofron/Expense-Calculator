package com.vxsprogramming.Expense.Calculator.controller;

import com.vxsprogramming.Expense.Calculator.dto.UserLoginDto;
import com.vxsprogramming.Expense.Calculator.dto.UserRegisterDto;
import com.vxsprogramming.Expense.Calculator.model.User;
import com.vxsprogramming.Expense.Calculator.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense/users")
@Validated
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto){
        userService.registerUser(userRegisterDto);
        return ResponseEntity.ok("Registration Successful!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid UserLoginDto userLoginDto, HttpSession session){
        // Authenticate user
        User loggedInUser = userService.loginUser(userLoginDto);

        if(loggedInUser != null){
            session.setAttribute("username", loggedInUser.getUsername());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Logged in successfully.");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpSession session){
        userService.logoutUser();
        return ResponseEntity.status(HttpStatus.OK).body("Logged out successfully");
    }





}
