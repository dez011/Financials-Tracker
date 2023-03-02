package com.example.demo.audit;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "change_transaction")
public class ChangeTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
