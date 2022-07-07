package com.dh.mercadolivre.desafiospring.exceptions;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
