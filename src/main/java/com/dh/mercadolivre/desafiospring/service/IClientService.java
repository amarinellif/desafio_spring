package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.model.Client;

import java.util.List;

public interface IClientService {
    ClientDto saveClient(Client client);

    List<ClientDto> getAllClient();

    List<ClientDto> getClientFilteredByState(String state);
}
