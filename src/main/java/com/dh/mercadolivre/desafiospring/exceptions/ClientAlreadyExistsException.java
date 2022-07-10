package com.dh.mercadolivre.desafiospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class that extends of the RunTimeException error class.
 * @author Diovana
 * @version 0.0.1
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ClientAlreadyExistsException extends RuntimeException {

    /**
     * This method is called by the ClientRepository when the user try insert a Client who is already exists
     * and return a customize message
     * @param message (String)
     */
    public ClientAlreadyExistsException(String message) {

        super(message);
    }
}
