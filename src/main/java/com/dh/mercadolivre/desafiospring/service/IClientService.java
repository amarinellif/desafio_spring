package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.model.Client;

import java.util.List;

/**
 * Interface to deal with the methods implemented on the ClientService class.
 */
public interface IClientService {
    /**
     * Method that receive an object of type Client, read and write a new client on the client.json file.
     * @param client an object of type Client
     * @return a list of objects of type ClientDto.
     */
    ClientDto saveClient(Client client);

    /**
     * Method that gets a list of objects of type ClienteDto.
     * @return a list of objects of type ClientDto.
     */
    List<ClientDto> getAllClient();

    /**
     * Method that filter a list of clients by the state attribute.
     * @param state String
     * @return a list of objects of type ClientDto filtered by the state attribute.
     */
    List<ClientDto> getClientFilteredByState(String state);
}
