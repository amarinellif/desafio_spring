package com.dh.mercadolivre.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long productId;
    private String name;
    private String category;
    private String brand;
    private String prestige;
    private Double price;
    private Integer quantity;
    private Boolean freeShipping;
}
