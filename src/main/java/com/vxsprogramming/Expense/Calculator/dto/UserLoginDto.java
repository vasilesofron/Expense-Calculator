package com.vxsprogramming.Expense.Calculator.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {

    @Email(message = "Invalid email.")
    private String email;

    @NotBlank(message = "Password is required.")
    private String password;


}
