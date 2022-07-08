
package com.dh.mercadolivre.desafiospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Class to extends RunTimeException and send message through super constructor
 *  @author Thiago Guimarães, Thiago Frozzi, Gabriela Azevedo, Diovana Valim, Rafael Cavalcante e Amanda Marinelli
 *  @version 0.0.1
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerException extends RuntimeException {

    /**
     * Call super and pass param message error about server error 500
     * @param message
     */
    public ServerException(String message) {
        super(message);
    }
}
