package com.bridgelabz.addressbookapp.Controller;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.dto.UserRegistrationDTO;
import com.bridgelabz.addressbookapp.model.UserData;
import com.bridgelabz.addressbookapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * @param userName
     * @param password
     * @return ResponseEntity
     */

    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> loginAccount(@RequestParam String userName ,@RequestParam String password){
        UserData userData = null;
        userData = userService.loginAccount(userName,password);
        ResponseDTO responseDTO = new ResponseDTO("Account Successfully Logged In",userData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
