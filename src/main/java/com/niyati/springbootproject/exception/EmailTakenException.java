package com.niyati.springbootproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmailTakenException extends RuntimeException {

    public EmailTakenException(String msg) {
        super(msg);

    }
}
