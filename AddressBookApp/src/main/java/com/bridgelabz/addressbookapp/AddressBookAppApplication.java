package com.bridgelabz.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@SpringBootApplication
@Slf4j
public class AddressBookAppApplication {

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(AddressBookAppApplication.class, args);
        log.info("Welcome to AddressBook App");
        log.info("Application Started in {} Environment",context.getEnvironment().getProperty("environment"));
        log.info("Database UserName : {}",context.getEnvironment().getProperty("spring.datasource.username"));

    }
}
