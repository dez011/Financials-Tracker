package com.example.demo.service;

import com.example.demo.entity.AbstractExternalUserTransaction;
import com.example.demo.entity.BankAccount;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDTO;
import com.example.demo.factory.UserFactory;
import com.example.demo.factory.UserFactoryHolder;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class UserService implements UserServiceIF {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    private final UserRepository userRepository;
    Handler consoleHandler = new ConsoleHandler();

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

//    @Transactional
//    public void createBankAccount(BankAccount bankAccount){
//        userRepository.saveNewCode(bankAccount);
//    }

//    public List<BankAccount> getAllCodes(){
//        return userRepository.findAll(); //.parallelStream().collect(Collectors.toList());
//    }

    @Override
    @Transactional
    public User createUser(UserDTO dto) {
        consoleHandler.setLevel(Level.ALL);
        User user = UserFactoryHolder.getUserFactory().createFromDTO(dto);

        User savedUser = userRepository.saveNewUser(user);
        LOGGER.info(String.format("\nCreated user with id %d", savedUser.id));
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    @Transactional
    public UserDTO loadUser(Long id) throws ValidationException {
        User user = userRepository.findUserById(id);
        if (user == null)
            throw new ValidationException(String.format("User with id %d not found", id));
        return user.toDTO();
    }

}
