package com.handehdy.enoca.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR(3000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(3001, "Invalid Parameter Error", BAD_REQUEST),
    ENTITY_NOT_SAVED(3002, "Invalid Parameter Error", BAD_REQUEST),
    EMPYOLEE_NOT_CREATED(3003, "Employee Not Created", BAD_REQUEST),
    COMPANY_NOT_CREATED(3004, "Company Not Created", BAD_REQUEST),
    EMPYOLEE_NOT_UPDATED(3005, "Invalid Parameter Error", BAD_REQUEST),
    COMPANY_NOT_UPDATED(3006, "Invalid Parameter Error", BAD_REQUEST),
    EMPYOLEE_NOT_FOUND(3007, "Invalid Parameter Error", BAD_REQUEST),
    COMPANY_NOT_FOUND(3008, "Invalid Parameter Error", BAD_REQUEST);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
