package com.github.numericguessbackend.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GameClosedError extends RuntimeException {

    public GameClosedError() {
        super();
    }

    public GameClosedError(String message) {
        super(message);
    }
}
