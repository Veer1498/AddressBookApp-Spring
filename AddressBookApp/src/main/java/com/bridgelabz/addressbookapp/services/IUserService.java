package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.UserLoginDTO;
import com.bridgelabz.addressbookapp.dto.UserRegistrationDTO;
import com.bridgelabz.addressbookapp.model.UserData;

import java.util.Optional;

public interface IUserService {
    /**
     *
     * @param userRegistrationDTO
     * @return
     */
    String createUserRegistration(UserRegistrationDTO userRegistrationDTO);

    /**
     *
     * @return
     */
    Optional<UserData> loginAccount(UserLoginDTO userLoginDTO);
}
