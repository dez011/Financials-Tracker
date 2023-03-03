package com.example.demo.factory;

import com.example.demo.entity.*;
import org.json.JSONObject;

import java.util.Map;

public class UserFactory {
    public User createFromDTO(UserDTO dto){
        return new User(dto);
    }

    public UserDTO createUserDTO(Map<String, Object> map){
        return new UserDTO(map);
    }

    public static BankAccount createBankAccountFromDTO(BankAccountDTO dto, User user){
        return new BankAccount(dto, user);
    }

    public BankAccountDTO createBankAccountFromJson(JSONObject value) {
        System.out.println("jval " + value);//jval {"accountType":"savings","transactions":[{"transactionAmount":500,"transactionDate":"2023-02-15T14:30:00Z"}]}

        return new BankAccountDTO(value);
//        return null;
    }

    public TransactionDTO createTransactionFromJson(JSONObject o) {
        return new TransactionDTO(o);
    }
}
