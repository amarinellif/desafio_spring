package com.dh.mercadolivre.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Method Getter implemented by Lombok lib for get access the private attributes of the Client Class
 */
@Getter

/**
 * Method Setter implemented by Lombok lib for set the private attributes of the Client Class
 */
@Setter

/**
 * Method Default Constructor implemented by Lombok lib
 */
@NoArgsConstructor

/**
 * Method Constructor of the Constructor Class
 */
@AllArgsConstructor


/**
 * Class for objects of Client type that contains attributes and methods
 * @author Diovana Valim
 * @version 0.0.1
 * @see java.lang.Object
 */
public class Client {
    private int id;
    private String name;
    private String cpf;
    private String address;
    private String city;
    private String state;
}