package com.bridgelabz.addressbookapp.Controller;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.dto.UserLoginDTO;
import com.bridgelabz.addressbookapp.dto.UserRegistrationDTO;
import com.bridgelabz.addressbookapp.model.UserData;
import com.bridgelabz.addressbookapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * Autowired User Services for using again and again.
     */
    @Autowired
    IUserService userService;

    /**
     *
     * @param userRegistrationDTO
     * @return ResponseEntity
     */
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerAccount(@RequestBody UserRegistrationDTO userRegistrationDTO){
        UserData userData = null;
        userData = userService.createUserRegistration(userRegistrationDTO);
        ResponseDTO responseDTO = new ResponseDTO("User has been registered",userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     *
     *
     * @return ResponseEntity
     */

    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> loginAccount(@RequestBody UserLoginDTO userLoginDTO){
        Optional<UserData> userData = null;
        userData = userService.loginAccount(userLoginDTO);
        ResponseDTO responseDTO = new ResponseDTO("Account Successfully Logged In",userData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
