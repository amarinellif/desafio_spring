package com.dh.mercadolivre.desafiospring.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
/**
 * Class to customize the return of errors response.
 * @author Thiago Guimarães, Thiago Frozzi, Gabriela Azevedo, Diovana Valim, Rafael Cavalcante e Amanda Marinelli
 * @version 0.0.1
 */
public class ExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
