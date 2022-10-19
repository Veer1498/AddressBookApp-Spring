package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.ContactData;

public interface IAddessBookService {
    /**
     * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
     * Author : Veer.Singa
     */
    String getWelcomeMessage();

    ContactData createContactData(ContactDTO contactDTO);
}
