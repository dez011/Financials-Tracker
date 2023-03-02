package com.example.demo.repository;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.User;

import java.util.List;

public interface UserRepository {
    void saveNewCode(BankAccount bankAccount);

    List<BankAccount> findAll();

    User saveNewUser(User user);

    List<User> findAllUsers();

    User findUserById(Long id);

}
