package com.example.demo.factory;

public class UserFactoryHolder {
    private static final UserFactory shapeFactory = new UserFactory();

    public static UserFactory getUserFactory(){
        return shapeFactory;
    }
}
