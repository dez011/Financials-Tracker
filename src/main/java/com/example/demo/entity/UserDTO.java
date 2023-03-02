package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends GeneralDTO{
    public String firstName;
    public String middleName;
    public String lastName;
    public List<BankAccountDTO> bankAccounts = new ArrayList<>();

}
