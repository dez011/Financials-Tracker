package com.example.demo.service;

import com.example.demo.entity.AbstractExternalUserTransaction;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDTO;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;
import java.util.List;

public interface UserServiceIF {
    @Transactional
    User createUser(UserDTO dto);

    List<User> getAllUsers();

    @Transactional
    UserDTO loadUser(Long id) throws ValidationException;


}
