package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Override
    public ClientDto saveClient(Client client) {
        return null;
    }

    @Override
    public List<ClientDto> getAllClient() {
        return null;
    }

    @Override
    public List<ClientDto> getClientFilteredByState(String state) {
        return null;
    }
}
