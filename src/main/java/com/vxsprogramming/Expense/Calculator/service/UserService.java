package com.vxsprogramming.Expense.Calculator.service;

import com.vxsprogramming.Expense.Calculator.dto.UserLoginDto;
import com.vxsprogramming.Expense.Calculator.dto.UserRegisterDto;
import com.vxsprogramming.Expense.Calculator.model.User;
import jakarta.servlet.http.HttpSession;

public interface UserService {

    boolean isUsernameAvailable(String username);

    boolean isEmailAvailable(String email);

    void registerUser(UserRegisterDto userRegisterDto);

    User loginUser(UserLoginDto userLoginDto);

    void logoutUser();

}
