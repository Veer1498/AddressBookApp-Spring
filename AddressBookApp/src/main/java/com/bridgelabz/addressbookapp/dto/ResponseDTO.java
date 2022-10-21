package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@Data
public class ResponseDTO {
    private String message;
    private Object data;

    /**
     *
     * @param message
     * @param data
     */
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
