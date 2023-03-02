package com.example.demo.entity;

import com.example.demo.factory.UserFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public
    Long id;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "middle_name")
    protected String middleName;

    @Column(name = "last_name")
    protected String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<BankAccount> bankAccounts = new ArrayList<>();

    public User(){}

    public User(UserDTO userDTO) {
        this.firstName = userDTO.firstName;
        this.middleName = userDTO.middleName;
        this.lastName = userDTO.lastName;
        this.bankAccounts = userDTO.bankAccounts.stream().map(o -> UserFactory.createBankAccountFromDTO(o, this)).collect(Collectors.toList());
    }

    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();
        dto.firstName = this.firstName;
        dto.middleName = this.middleName;
        dto.lastName = this.lastName;
        dto.bankAccounts = this.bankAccounts.stream().map(BankAccount::toDTO).collect(Collectors.toList());
        return dto;
    }
}
