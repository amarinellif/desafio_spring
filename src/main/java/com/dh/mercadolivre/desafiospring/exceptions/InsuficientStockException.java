package com.dh.mercadolivre.desafiospring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class to extends RunTimeException and send message through the super constructor.
 * @author Thiago Guimarães, Thiago Frozzi, Gabriela Azevedo, Diovana Valim, Rafael Cavalcante e Amanda Marinelli
 * @version 0.0.1
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InsuficientStockException extends RuntimeException {

    /**
     * Call super and pass param message error about insuficient stock
     * @param message
     */
    public InsuficientStockException(String message) {
        super(message);
    }
}





