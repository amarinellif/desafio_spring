package com.dh.mercadolivre.desafiospring.exceptions;

/**
 *
 */
public class ClientNotFoundException extends RuntimeException {

    /**
     * @author Diovana
     * This method is called by the ClientRepository when the user try filter Clients List filtered by state,
     * and no found for this statereturn a customize message
     * @param message
     */
    public ClientNotFoundException(String message) {
        super(message);
    }
}
