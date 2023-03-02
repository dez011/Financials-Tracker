package com.example.demo.factory;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.BankAccountDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDTO;

public class UserFactory {
    public static User createFromDTO(UserDTO dto){
        return new User(dto);
    }

    public static BankAccount createBankAccountFromDTO(BankAccountDTO dto, User user){
        return new BankAccount(dto, user);
    }
}
