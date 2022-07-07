package com.dh.mercadolivre.desafiospring.handler;

import com.dh.mercadolivre.desafiospring.exceptions.InsuficientStockException;
import com.dh.mercadolivre.desafiospring.exceptions.NotFoundException;
import com.dh.mercadolivre.desafiospring.exceptions.ExceptionDetails;
import com.dh.mercadolivre.desafiospring.exceptions.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;

@ControllerAdvice
public class ExHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundEx(NotFoundException ex) {
        return new ResponseEntity<ExceptionDetails>(
                ExceptionDetails.builder()
                        .title("Objeto não encontrado.")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ExceptionDetails> handlerErrorServer(ServerException ex) {
        return new ResponseEntity<ExceptionDetails>(
                ExceptionDetails.builder()
                        .title("Erro no servidor.")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(InsuficientStockException.class)
    public ResponseEntity<ExceptionDetails> handlerInsuficientStockException(InsuficientStockException ex) {
        return new ResponseEntity<ExceptionDetails>(
                ExceptionDetails.builder()
                        .title("Estoque insuficiente.")
                        .status(HttpStatus.NOT_ACCEPTABLE.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_ACCEPTABLE);
    }
}
