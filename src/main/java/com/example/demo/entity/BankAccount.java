package com.example.demo.entity;

import org.json.JSONObject;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public String accountType;

    @OneToMany(mappedBy = "bankAccount")
    public List<Transaction> transactions;
//    bidirectional one-to-many relationship between the BankAccount and Transaction entities. The mappedBy attribute specifies the name of the field in the Transaction entity that owns the relationship

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

    public BankAccount(){}

    public BankAccount(String accountType){
        this.accountType = accountType;
    }

    public BankAccount(BankAccountDTO dto, User user) {
        this.accountType = dto.accountType;
        this.user = user;

    }

    public BankAccount(JSONObject jsonArray) {

//        this.accountType = jsonArray.
    }

    public BankAccountDTO toDTO() {
        return new BankAccountDTO.Builder().accountType(this.accountType).user(this.user).buildBankAccountDTO();
    }
}
