package com.asap.seguradora.exception;

import com.asap.seguradora.util.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException{
    public NoContentException() {
        super(Messages.NOT_FOUND_RESULT);
    }

    public NoContentException(String errorMessage) {
        super(errorMessage);
    }
}
