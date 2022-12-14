package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.UserLoginDTO;
import com.bridgelabz.addressbookapp.dto.UserRegistrationDTO;
import com.bridgelabz.addressbookapp.model.UserData;
import com.bridgelabz.addressbookapp.repository.UserRepository;
import com.bridgelabz.addressbookapp.utility.AddressBookUtility;
import com.bridgelabz.addressbookapp.utility.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressBookUtility addressBookUtility;
    @Autowired
    MailSender mailSender;
    public String createUserRegistration(UserRegistrationDTO userRegistrationDTO) {
        UserData userData = new UserData(userRegistrationDTO);
        userRepository.save(userData);
        String token = addressBookUtility.createToken(userData.getUserId());
        mailSender.sendEmail(userRegistrationDTO.getUserEmail(),"Registration Succesful","Account Created with "+userData);
        return token;
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
