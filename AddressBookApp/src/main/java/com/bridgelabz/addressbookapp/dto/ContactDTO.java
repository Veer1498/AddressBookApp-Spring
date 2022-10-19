package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@Data
public class ContactDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name Invalid")
    @NotBlank(message = "Should Not be Empty")
    private String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last name Invalid")
    @NotBlank(message = "Should Not be Empty")
    private String lasName;

    @NotBlank(message = "Should Not be Empty")
    private String address;

    @NotBlank(message = "Should Not be Empty")
    private String city;
    @NotBlank(message = "Should Not be Empty")
    private String state;

    @Pattern(regexp = "^[1-9]{6}$", message = "PINCODE Invalid")
    @NotBlank(message = "Should Not be Empty")
    private int pin;

    @Pattern(regexp = "^[1-9]{10}$", message = "Phone Number Invalid")
    @NotBlank(message = "Should Not be Empty")
    private long phoneNo;

    @Email(message = "Email Invalid")
    @NotBlank(message = "Should Not be Empty")
    private String email;
}
