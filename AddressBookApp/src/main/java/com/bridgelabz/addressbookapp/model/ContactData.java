package com.bridgelabz.addressbookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class ContactData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contactId;
    private String firstName;
    private String lasName;
    private String address;
    private String city;
    private String state;
    private int pin;
    private long phoneNo;
    private String email;
}
