package com.bridgelabz.addressbookapp.services;

import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements IAddessBookService{

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Address Book Application";
    }
}
