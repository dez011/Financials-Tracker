package com.example.demo.entity;

import com.example.demo.factory.UserFactoryHolder;
import javafx.util.Builder;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankAccountDTO extends GeneralDTO{
    public String accountType;
    public User user;
    public List<TransactionDTO> transactions;

    BankAccountDTO(Builder builder){
        this.accountType = builder.accountType;
        this.user = builder.user;
    }
    public BankAccountDTO(JSONObject value){
        this.accountType = value.optString("accountType");
        this.transactions = getJsonObjects(value).stream().map(o -> UserFactoryHolder.getUserFactory().createTransactionFromJson(o))
                .collect(Collectors.toList());
    }

    private List<JSONObject> getJsonObjects(JSONObject value) {
        List<JSONObject> jlist = new ArrayList<>();
        for(Object o : value.getJSONArray("transactions")){
            jlist.add((JSONObject) o);
        }
        return jlist;
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
