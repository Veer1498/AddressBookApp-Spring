package com.bridgelabz.addressbookapp.Controller;

import com.bridgelabz.addressbookapp.services.IAddessBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    IAddessBookService addessBookService;
    /**
     *
     * @return
     */
    @GetMapping(value = {"","/welcome"})
    public String welcomeMessage(){
        return addessBookService.getWelcomeMessage();
    }
}
