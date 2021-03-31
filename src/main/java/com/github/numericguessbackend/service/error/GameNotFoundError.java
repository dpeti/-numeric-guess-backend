package com.github.numericguessbackend.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameNotFoundError extends RuntimeException{

    public GameNotFoundError() {
    }

    public GameNotFoundError(String message) {
        super(message);
    }
}
