package com.example.demo.entity;

import javafx.util.Builder;

public class BankAccountDTO extends GeneralDTO{
    public String accountType;
    public User user;

    BankAccountDTO(Builder builder){
        this.accountType = builder.accountType;
        this.user = builder.user;
    }

    public BankAccountDTO() {
    }

    public static class Builder{
        private String accountType;
        private User user;


        public Builder accountType(String accountType){
            this.accountType = accountType;
            return this;
        }
        public Builder user(User user){
            this.user = user;
            return this;
        }
        public BankAccountDTO buildBankAccountDTO(){
            return new BankAccountDTO(this);
        }
    }
}
