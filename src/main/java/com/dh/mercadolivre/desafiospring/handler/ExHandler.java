package com.dh.mercadolivre.desafiospring.handler;

import com.dh.mercadolivre.desafiospring.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * class that handle exceptions that are thrown in the code
 * @author  Rafael Cavalcante,  Thiago Frozzi, Amanda Marinelli
 * @version 0.0.1
 */
@ControllerAdvice
public class ExHandler {

    /**
     *method that captures a NotFoundException and build a response to send via http
     * @param ex
     * @return an object with the details of the exception
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundEx(NotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Object Not Found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

    /**
     *method that captures a ServerException and build a response to send via http
     * @param ex
     * @return an object with the details of the exception
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
     *method that captures a InsuficientStockException and build a response to send via http
     * @param ex
     * @return an object with the details of the exception
     */
    @ExceptionHandler(InsuficientStockException.class)
    public ResponseEntity<ExceptionDetails> handlerInsuficientStockException(InsuficientStockException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Insufficient Stock")
                        .status(HttpStatus.NOT_ACCEPTABLE.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     *method that captures a ClientAlreadyExistsException and build a response to send via http
     * @param ex
     * @return an object with the details of the exception
     */
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

    /**
     *method that captures a InvalidParamsException and build a response to send via http
     * @param ex
     * @return an object with the details of the exception
     */
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

    /**
     *method that captures a ClientNotFoundException and build a response to send via http
     * @param ex
     * @return an object with the details of the exception
     */
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
