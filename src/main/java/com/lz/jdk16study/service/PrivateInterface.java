package com.lz.jdk16study.service;

public interface PrivateInterface {

    private void printF(){
        System.out.println("lengleng");
    }

    default void getPassword(){
        printF();
        System.out.println("password");
    }

}
