package com.bridgelabz.addressbookapp.services;

import org.springframework.stereotype.Service;
/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@Service
public class AddressBookService implements IAddessBookService{

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Address Book Application";
    }
}
