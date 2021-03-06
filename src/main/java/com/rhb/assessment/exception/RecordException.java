package com.rhb.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordException extends Exception {

    private static final long serialVersionUID = 1L;

    public RecordException(String message) {
        super(message);
    }

    public RecordException(String message, Throwable t) {
        super(message, t);
    }
}
