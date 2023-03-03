package com.example.demo.entity;

import com.example.demo.factory.UserFactory;
import com.example.demo.factory.UserFactoryHolder;

import java.util.Map;

public class ExternalUserTransaction extends AbstractExternalUserTransaction{
    public Map<String, Object> parsedFields;
    public UserDTO userDTO;

    public void buildUser() { //move this to a subclass of this class
        userDTO = UserFactoryHolder.getUserFactory().createUserDTO(this.parsedFields);
    }


}
