package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@Data
public class ContactDTO {
    private String firstName;
    private String lasName;
    private String address;
    private String city;
    private String state;
    private int pin;
    private long phoneNo;
    private String email;
}
