package com.vxsprogramming.Expense.Calculator.repository;

import com.vxsprogramming.Expense.Calculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Query to find username.
    User findByUsername(String username);
    // Query to find email.
    User findByEmail(String email);
}
