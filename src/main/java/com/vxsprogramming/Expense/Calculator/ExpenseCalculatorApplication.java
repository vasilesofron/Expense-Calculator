package com.vxsprogramming.Expense.Calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ExpenseCalculatorApplication {


	public static void main(String[] args) {
		SpringApplication.run(ExpenseCalculatorApplication.class, args);
	}

}
