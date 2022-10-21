package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.ContactData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
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
    public ContactData createContactData(ContactDTO contactDTO) {
        ContactData contactData = null;
        contactData = new ContactData(contactDTO);
        return addressBookRepository.save(contactData);
    }

    /**
     *
     * @param contactId
     * @param contactDTO
     * @return
     */
    @Override
    public ContactData updateContactData(int contactId, ContactDTO contactDTO) {
        ContactData contactData = addressBookRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Id May Not be Existed"));
        contactData.updateContactInfo(contactDTO);
        return addressBookRepository.save(contactData);
    }

    /**
     *
     * @param contactId
     * @return
     */
    @Override
    public ContactData getContactbyId(int contactId) {

        return addressBookRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Id not available"));
    }

    /**
     *
     * @param contactId
     */
    @Override
    public void deleteContactById(int contactId) {
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
