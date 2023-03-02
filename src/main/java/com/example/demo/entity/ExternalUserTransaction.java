package com.example.demo.entity;

import java.util.Map;

public class ExternalUserTransaction extends AbstractExternalUserTransaction{
    public Map<String, String> parsedFields;

    public UserDTO buildUser() { //move this to a subclass of this class
        return null;
    }


}
