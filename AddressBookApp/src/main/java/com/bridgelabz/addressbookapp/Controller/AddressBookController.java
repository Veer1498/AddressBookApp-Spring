package com.bridgelabz.addressbookapp.Controller;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.ContactData;
import com.bridgelabz.addressbookapp.services.IAddessBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    /**
     * Autowired the AddressBook Service
     */
    @Autowired
    IAddessBookService addessBookService;
    /**
     *
     * Just a Welcome Message.
     */
    @GetMapping(value = {"","/welcome"})
    public String welcomeMessage(){
        return addessBookService.getWelcomeMessage();
    }

    /**
     *Method to Add Data to Database By Passing Data
     * @param contactDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> saveDataIntoDataBase(@Valid @RequestBody ContactDTO contactDTO){
        String token = addessBookService.createContactData(contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Data Created SuccessFully",token);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    /**
     *Method to Update earlier data by using ID
     * @param token
     * @param contactDTO
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateDataofDataBase(@RequestHeader String token, @Valid @RequestBody ContactDTO contactDTO){
        ContactData contactData = null;
        contactData = addessBookService.updateContactData(token,contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated the Contact Information for this ID",contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * Method to Get Data to see using ID
     * @param token
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getContactbyId(@RequestHeader String token){
        ContactData contactData = null;
        contactData = addessBookService.getContactbyId(token);
        ResponseDTO responseDTO = new ResponseDTO("Got the Contact Information for this ID",contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     *Method to Delete by ID
     * @param contactId
     */
    @DeleteMapping("delete")
    public void deleteContactById(@RequestHeader String token){
        addessBookService.deleteContactById(token);
    }

    /**
     *
     * @return Response Entity of sorted cities
     */
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortByCity(){
        List<ContactData>  contactList = null;
        contactList = addessBookService.sortContactsBycity();
        ResponseDTO responseDTO = new ResponseDTO("Sorted Contacts Details",contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     *
     * @return Response entity of sorted States
     */
    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortByState(){
        List<ContactData>  contactList = null;
        contactList = addessBookService.sortContactsByState();
        ResponseDTO responseDTO = new ResponseDTO("Sorted Contacts Details",contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
