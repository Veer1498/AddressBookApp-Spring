package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.ContactData;

import java.util.List;

public interface IAddessBookService {
    /**
     * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
     * Author : Veer.Singa
     */
    String getWelcomeMessage();

    String createContactData(ContactDTO contactDTO);

    ContactData updateContactData(String token, ContactDTO contactDTO);

    ContactData getContactbyId(String token);

    void deleteContactById(String token);

    List<ContactData> sortContactsBycity();

    List<ContactData> sortContactsByState();

    List<ContactData>  getAll();
}
