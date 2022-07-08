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
     * This method is called by the ClientRepository when the user try insert a Client who is already exists
     * and return a customize message
     * @param message
     */
    public ClientAlreadyExistsException(String message) {

        super(message);
    }
}
