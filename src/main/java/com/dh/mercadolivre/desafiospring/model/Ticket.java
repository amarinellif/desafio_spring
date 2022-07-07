package com.dh.mercadolivre.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private long id;
    private List<Product> articles;
    private double total;
}
