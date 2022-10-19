package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

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
