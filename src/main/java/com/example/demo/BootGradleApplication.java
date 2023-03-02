package com.example.demo;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.demo.repository"})
//@EntityScan(basePackages = {"com.example.demo.entity"})
@EntityScan("com.example.demo.entity")
@ComponentScan("com.example.demo")
public class BootGradleApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(BootGradleApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Code code = new Code("new code");
//        codeService.addCode(code);
//
//        List<Code> bankAccounts = codeService.getAllCodes();
//        for (Code c : bankAccounts){
//            System.out.println("Code: " + c.name);
//        }
//    }

}
