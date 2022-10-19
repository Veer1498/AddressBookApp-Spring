package com.bridgelabz.addressbookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactData {
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
