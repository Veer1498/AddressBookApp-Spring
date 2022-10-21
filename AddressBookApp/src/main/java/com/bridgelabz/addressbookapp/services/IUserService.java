package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.UserRegistrationDTO;
import com.bridgelabz.addressbookapp.model.UserData;

public interface IUserService {
    /**
     *
     * @param userRegistrationDTO
     * @return
     */
    UserData createUserRegistration(UserRegistrationDTO userRegistrationDTO);

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    UserData loginAccount(String userName, String password);
}
