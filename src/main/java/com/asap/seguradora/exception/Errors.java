package com.asap.seguradora.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Errors {
    private Map<String, String> errors;

    public Errors(BindingResult bindResult) {
        this.errors = new HashMap<>();

        bindResult.getAllErrors().forEach(error ->
                this.errors.put(
                        ((FieldError) error).getField(), error.getDefaultMessage()
                )
        );
    }

    public Errors(Exception ex) {
        this.errors = new HashMap<>();
        this.errors.put("message", ex.toString());
    }
}
