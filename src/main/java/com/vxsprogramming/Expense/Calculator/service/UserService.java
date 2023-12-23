package com.vxsprogramming.Expense.Calculator.service;

import com.vxsprogramming.Expense.Calculator.dto.UserRegisterDto;

public interface UserService {

    boolean isUsernameAvailable(String username);

    boolean isEmailAvailable(String email);

    void registerUser(UserRegisterDto userRegisterDto);

}
