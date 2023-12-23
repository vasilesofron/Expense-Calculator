package com.vxsprogramming.Expense.Calculator.controller;

import com.vxsprogramming.Expense.Calculator.dto.UserRegisterDto;
import com.vxsprogramming.Expense.Calculator.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}
