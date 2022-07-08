
package com.dh.mercadolivre.desafiospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerException extends RuntimeException {

    /**
     *
     * @param message
     */
    public ServerException(String message) {
        super(message);
    }
}
