package com.dh.mercadolivre.desafiospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InsuficientStockException extends RuntimeException {

    /**
     *
     * @param message
     */
    public InsuficientStockException(String message) {
        super(message);
    }
}





