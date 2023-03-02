package com.example.demo.service;

import com.example.demo.entity.AbstractExternalUserTransaction;
import com.example.demo.entity.ExternalUserTransaction;
import com.example.demo.entity.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class ExternalJsonServiceImpl implements ExternalJsonService{

    @Override
    public void processExternalParsedJson(ExternalUserTransaction externalJsonTransaction) {
        UserDTO userDTO = externalJsonTransaction.buildUser();
//        System.out.println(userDTO.toString());
    }
}
