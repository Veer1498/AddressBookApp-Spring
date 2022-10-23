package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.ContactData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.utility.AddressBookUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@Service
public class AddressBookService implements IAddessBookService{

    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    AddressBookUtility addressBookUtility;

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Address Book Application";
    }

    /**
     *
     * @param contactDTO
     * @return
     */
    @Override
    public String createContactData(ContactDTO contactDTO) {
        ContactData contactData = new ContactData(contactDTO);
        addressBookRepository.save(contactData);
        String token = addressBookUtility.createToken(contactData.getContactId());
        return token;
    }

    /**
     *
     * @param token
     * @param contactDTO
     * @return
     */
    @Override
    public ContactData updateContactData(String token, ContactDTO contactDTO) {
        int contactId = addressBookUtility.decodeJWT(token);
        ContactData contactData = addressBookRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Id May Not be Existed"));
        contactData.updateContactInfo(contactDTO);
        return addressBookRepository.save(contactData);
    }

    /**
     *
     * @param token
     * @return
     */
    @Override
    public ContactData getContactbyId(String token) {
        int contactId = addressBookUtility.decodeJWT(token);
        return addressBookRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Id not available"));
    }

    /**
     *
     * @param token
     */
    @Override
    public void deleteContactById(String token) {

        int contactId = addressBookUtility.decodeJWT(token);
        addressBookRepository.deleteById(contactId);
    }

    @Override
    public List<ContactData> sortContactsBycity() {
        return addressBookRepository.sortByCity();
    }

    @Override
    public List<ContactData> sortContactsByState() {
        return addressBookRepository.sortByState();
    }
}
