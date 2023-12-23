package com.vxsprogramming.Expense.Calculator.service;

import com.vxsprogramming.Expense.Calculator.dto.UserRegisterDto;
import com.vxsprogramming.Expense.Calculator.exception.EmailAlreadyInUseException;
import com.vxsprogramming.Expense.Calculator.exception.UsernameAlreadyInUseException;
import com.vxsprogramming.Expense.Calculator.model.User;
import com.vxsprogramming.Expense.Calculator.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(@Valid UserRegisterDto userRegisterDto){
        // Checking if the email is available.
        if(!isEmailAvailable(userRegisterDto.getEmail())){
            throw new EmailAlreadyInUseException("Email already in use!");
        }
        // Checking if the username is available.
        if(!isUsernameAvailable(userRegisterDto.getUsername())){
            throw new UsernameAlreadyInUseException("Username already in use!");
        }
        // Encoding the password.
        String encodedPassword = passwordEncoder.encode(userRegisterDto.getPassword());
        // Creating a new user.
        User user = new User(userRegisterDto.getUsername(), encodedPassword, userRegisterDto.getEmail());
        // Saving the user.
        userRepository.save(user);
    }





    // (?) Maybe they should be moved in another package.
    // Method to check if username is available.
    public boolean isUsernameAvailable(String username){
        return userRepository.findByUsername(username) == null;
    }
    // Method to check if email is available.
    public boolean isEmailAvailable(String email){
        return userRepository.findByEmail(email) == null;
    }

}
