package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.UserLoginDTO;
import com.bridgelabz.addressbookapp.dto.UserRegistrationDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.UserData;
import com.bridgelabz.addressbookapp.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<UserData> loginAccount(UserLoginDTO userLoginDTO) {
        Optional<UserData> userData = userRepository.checkLogin(userLoginDTO.getUserName(), userLoginDTO.getPassword());
        if(userData.isPresent()){
            return userData;
        }
        else
            return null;
    }
}
