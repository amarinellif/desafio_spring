package com.dh.mercadolivre.desafiospring.dto;

import com.dh.mercadolivre.desafiospring.model.Client;
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
 * Method Default Constructor implemented by Lombok lib.
 */
@NoArgsConstructor
/**
 * Method Constructor of the Client Class.
 */
public class ClientDto {
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;

    /**
     * Constructor method that receives an object of type Client and returns an ClientDto object
     * @param client object of type Client.
     */
    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.address = client.getAddress();
        this.city = client.getCity();
        this.state = client.getState();
    }
}