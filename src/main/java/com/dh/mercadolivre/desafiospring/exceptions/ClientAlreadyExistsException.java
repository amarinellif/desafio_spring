package com.dh.mercadolivre.desafiospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ClientAlreadyExistsException extends RuntimeException {

    /**
     * @author Diovana
     * @param message
     */
    public ClientAlreadyExistsException(String message) {
        super(message);
    }
}
