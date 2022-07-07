package com.dh.mercadolivre.desafiospring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Method Getter implemented by Lombok lib for get access the private attributes of the PurchaseRequest Class
 */
@Getter

/**
 * Method Setter implemented by Lombok lib for set the private attributes of the PurchaseRequest Class
 */
@Setter

/**
 * Method Default Constructor implemented by Lombok lib
 */
@NoArgsConstructor

/**
 * Method Constructor of the PurchaseRequest Class
 */
@AllArgsConstructor

/**
 * Class for objects of PurchaseRequest type that contains attributes and methods for create a request
 * @author Rafael Cavalcante
 * @version 0.0.1
 * @see java.lang.Object
 */
public class PurchaseRequest {
    private Long productId;
    private Integer quantity;
}
