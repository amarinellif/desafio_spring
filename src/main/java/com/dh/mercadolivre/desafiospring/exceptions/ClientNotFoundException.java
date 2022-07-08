package com.dh.mercadolivre.desafiospring.exceptions;

/**
 *
 */
public class ClientNotFoundException extends RuntimeException {

    /**
     *
     * @param message
     */
    public ClientNotFoundException(String message) {
        super(message);
    }
}
