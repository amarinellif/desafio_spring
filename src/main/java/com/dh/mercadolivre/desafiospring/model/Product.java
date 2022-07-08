package com.dh.mercadolivre.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Method Getter implemented by Lombok lib for get access the private attributes of the Product Class
 */
@Getter

/**
 * Method Setter implemented by Lombok lib for set the private attributes of the Product Class
 */
@Setter

/**
 * Method Default Constructor implemented by Lombok lib
 */
@NoArgsConstructor

/**
 * Method Constructor of the Product Class
 */
@AllArgsConstructor

/**
 * Class for objects of Product type that contains attributes and methods
 * @author Gabriela Azevedo
 * @version 0.0.1
 * @see java.lang.Object
 */
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
