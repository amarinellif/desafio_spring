package com.dh.mercadolivre.desafiospring.handler;

import com.dh.mercadolivre.desafiospring.exceptions.NotFoundException;
import com.dh.mercadolivre.desafiospring.exceptions.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import java.time.LocalDateTime;

@ControllerAdvice
public class NotFoundExHandler {

    public ResponseEntity<NotFoundExceptionDetails> handlerNotFoundEx(NotFoundException ex) {
        return new ResponseEntity<NotFoundExceptionDetails>(
                NotFoundExceptionDetails.builder()
                        .title("Objeto não encontrado")
                        .status(HttpStatus.NOT_FOUND.value())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }
}
