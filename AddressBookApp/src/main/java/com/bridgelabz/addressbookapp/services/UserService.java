package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.UserRegistrationDTO;
import com.bridgelabz.addressbookapp.model.UserData;
import com.bridgelabz.addressbookapp.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    public UserData createUserRegistration(UserRegistrationDTO userRegistrationDTO) {
        UserData userData = null;
        userData = new UserData(userRegistrationDTO);
        return userRepository.save(userData);
    }

    @Override
    public UserData loginAccount(String userName, String password) {
        return userRepository.checkLogin(userName,password);
    }

    ;
}
