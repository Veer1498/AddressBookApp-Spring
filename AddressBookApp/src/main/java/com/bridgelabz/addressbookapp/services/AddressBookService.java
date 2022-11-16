package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.ContactData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.utility.AddressBookUtility;
import com.bridgelabz.addressbookapp.utility.MailSender;
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

    @Autowired
    MailSender mailSender;

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
        mailSender.sendEmail(contactData.getEmail(),
                "Successfully Saved Your Contact",
                "Your Contact Has Been Saved By VEER Successfully !!" +
                        "\n Please Contact Him If Any Mistakes in Details," +
                        "\n Name : "+contactData.getFirstName()+" "+contactData.getLastName()+
                        "\n Phone Number :"+contactData.getPhoneNo()+
                        "\n\n\nVeer,\nDeveloper,\nIndia.");
        return contactData.toString();
    }

    /**
     *
     * @param id
     * @param contactDTO
     * @return
     */
    @Override
    public ContactData updateContactData(int id, ContactDTO contactDTO) {
        ContactData contactData = addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Id May Not be Existed"));
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
     * @param id
     */
    @Override
    public void deleteContactById(int id) {

        addressBookRepository.deleteById(id);
    }

    @Override
    public List<ContactData> sortContactsBycity() {
        return addressBookRepository.sortByCity();
    }

    @Override
    public List<ContactData> sortContactsByState() {
        return addressBookRepository.sortByState();
    }

    @Override
    public List<ContactData> getAll() {
        return addressBookRepository.findAll();
    }
}
