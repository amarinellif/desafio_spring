package com.dh.mercadolivre.desafiospring.exceptions;

/**
 * Class that extends of the RunTimeException error class.
 * @author Diovana
 * @version 0.0.1
 */
public class ClientNotFoundException extends RuntimeException {

    /**
     * This method is called by the ClientRepository when the user try filter Clients List filtered by state,
     * and no found for this state return a customize message
     * @param message (String)
     */
    public ClientNotFoundException(String message) {
        super(message);
    }
}
