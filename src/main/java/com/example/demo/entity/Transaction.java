package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "amount")
    protected double amount;

    @ManyToOne
    @JoinColumn(name = "bank_account_id", nullable = false)
    private BankAccount bankAccount;
//    many-to-one relationship between the Transaction and BankAccount entities. The @JoinColumn annotation specifies the name of the foreign key column in the transaction table that references the id column in the bank_account table.

    public Transaction() {
    }
}
