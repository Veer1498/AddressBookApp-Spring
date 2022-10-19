package com.bridgelabz.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@SpringBootApplication
public class AddressBookAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppApplication.class, args);
        System.out.println("Welcome to AddressBook App");
    }
}
