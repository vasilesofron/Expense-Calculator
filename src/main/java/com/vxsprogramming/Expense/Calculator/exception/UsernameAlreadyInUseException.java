package com.vxsprogramming.Expense.Calculator.exception;

public class UsernameAlreadyInUseException extends RuntimeException{

    public UsernameAlreadyInUseException(String message){
        super(message);
    }

}
