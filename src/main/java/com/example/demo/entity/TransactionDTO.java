package com.example.demo.entity;

import org.json.JSONObject;

public class TransactionDTO extends GeneralDTO{

    public double amount;
    public BankAccountDTO bankAccount;

    public TransactionDTO(JSONObject o) {
        this.amount = o.optDouble("transactionAmount");
    }
}
