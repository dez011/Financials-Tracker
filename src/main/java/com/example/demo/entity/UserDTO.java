package com.example.demo.entity;

import com.example.demo.audit.MyLogger;
import com.example.demo.factory.UserFactoryHolder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UserDTO extends GeneralDTO{
    public String firstName;
    public String middleName;
    public String lastName;
    public List<BankAccountDTO> bankAccounts = new ArrayList<>();

    public UserDTO(){}

    public UserDTO(Map<String, Object> map) {
//        super(); parser field: {firstName=John, lastName=Doe,
//        bankAccounts=[
//        {"accountType":"checking","transactions":
//        [
//        {"transactionAmount":100,"transactionDate":"2023-02-28T23:59:59Z"},
//        {"transactionAmount":-50,"transactionDate":"2023-03-01T12:00:00Z"}]},
//        {"accountType":"savings","transactions":[{"transactionAmount":500,
//        "transactionDate":"2023-02-15T14:30:00Z"}]
//        }],
//        middleName=Smith}
        this.firstName = getString(map, "firstName");
        this.middleName = getString(map, "middleName");
        this.lastName = getString(map, "lastName");
        JSONArray j = (JSONArray) map.get("bankAccounts");
        List<JSONObject> jlist = new ArrayList<>();
        for (Object o : j) {
            jlist.add((JSONObject) o);
        }
        this.bankAccounts = jlist.stream()
                .map(o -> UserFactoryHolder.getUserFactory().createBankAccountFromJson(o))
                .collect(Collectors.toList());
        MyLogger.logInfo(this.toString());
    }

    private String getString(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value != null ? String.valueOf(value) : null;
    }
}
