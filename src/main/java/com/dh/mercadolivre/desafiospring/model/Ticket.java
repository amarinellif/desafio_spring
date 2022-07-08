package com.dh.mercadolivre.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Method Getter implemented by Lombok lib for get access the private attributes of the Ticket Class
 */
@Getter

/**
 * Method Setter implemented by Lombok lib for set the private attributes of the Ticket Class
 */
@Setter

/**
 * Method Default Constructor implemented by Lombok lib
 */
@NoArgsConstructor

/**
 * Method Constructor of the Ticket Class
 */
@AllArgsConstructor

/**
 * Class for objects of Ticket type that contains attributes and methods for create a ticket with the
 * productId, products list and total of the purchase
 * @author Rafael Cavalcante
 * @version 0.0.1
 * @see java.lang.Object
 */
public class Ticket {
    private long id;
    private List<Product> articles;
    private double total;
}
