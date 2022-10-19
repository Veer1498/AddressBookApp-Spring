package com.bridgelabz.addressbookapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    /**
     *
     * @return
     */
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to AddressBook Application";
    }
}
