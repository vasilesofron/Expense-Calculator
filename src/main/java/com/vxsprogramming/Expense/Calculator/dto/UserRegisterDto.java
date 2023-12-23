package com.vxsprogramming.Expense.Calculator.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {

    @NotBlank(message = "Username is required.")
    private String username;

    @Email(message = "Invalid email address.")
    private String email;

    @NotBlank(message = "Password is required.")
    private String password;


}
