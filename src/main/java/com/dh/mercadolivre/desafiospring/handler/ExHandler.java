package com.dh.mercadolivre.desafiospring.handler;

import com.dh.mercadolivre.desafiospring.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 *
 */
@ControllerAdvice
public class ExHandler {

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundEx(NotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
<<<<<<< HEAD
                        .title("Not Found Object")
=======
                        .title("Object Not Found")
>>>>>>> c4d3d348d333d28f711c4804c6a2601d3692f975
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ExceptionDetails> handlerErrorServer(ServerException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Internal Server Error")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(InsuficientStockException.class)
    public ResponseEntity<ExceptionDetails> handlerInsuficientStockException(InsuficientStockException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
<<<<<<< HEAD
                        .title("Insufficient stock!")
=======
                        .title("Insufficient Stock")
>>>>>>> c4d3d348d333d28f711c4804c6a2601d3692f975
                        .status(HttpStatus.NOT_ACCEPTABLE.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerClientAlreadyExistsException(ClientAlreadyExistsException ex) {
        return new ResponseEntity<ExceptionDetails>(
                ExceptionDetails.builder()
                        .title("Client Already Exists")
                        .status(HttpStatus.CONFLICT.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(InvalidParamsException.class)
    public ResponseEntity<ExceptionDetails> handlerInvalidParamsException(InvalidParamsException ex) {
        return new ResponseEntity<ExceptionDetails>(
                ExceptionDetails.builder()
                        .title("Invalid Parameter Type")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerClientNotFoundException(ClientNotFoundException ex) {
        return new ResponseEntity<ExceptionDetails>(
                ExceptionDetails.builder()
                        .title("Client Not Found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}
