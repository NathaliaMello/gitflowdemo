package com.nathaliamello.gitflowdemo.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

    private final List<String> errors;
    public ValidationException(List<String> errors) {
        super("Erro de validação");
        this.errors = errors;
    }

}
