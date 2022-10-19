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

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> saveDataIntoDataBase(@Valid @RequestBody ContactDTO contactDTO){
        ContactData contactData = null;
        contactData = addessBookService.createContactData(contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Data Created SuccessFully",contactData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
