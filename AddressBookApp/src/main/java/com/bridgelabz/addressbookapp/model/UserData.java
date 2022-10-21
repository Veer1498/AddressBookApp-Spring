package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.UserRegistrationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userEmail;
    private String password;

    /**
     *
     * @param userRegistrationDTO
     */
    public UserData(UserRegistrationDTO userRegistrationDTO) {
        this.userName = userRegistrationDTO.getUserName();
        this.userEmail = userRegistrationDTO.getUserEmail();
        this.password = userRegistrationDTO.getPassword();
    }

}
