package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.model.Client;

import java.util.List;

/**
 *
 */
public interface IClientService {
    /**
     *
     * @param client
     * @return
     */
    ClientDto saveClient(Client client);

    /**
     *
     * @return
     */
    List<ClientDto> getAllClient();

    /**
     *
     * @param state
     * @return
     */
    List<ClientDto> getClientFilteredByState(String state);
}
