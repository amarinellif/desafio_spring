package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.model.Client;
import com.dh.mercadolivre.desafiospring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto saveClient(Client client) {
        String nameRegex = "[A-Z][a-z]* [A-Z][a-z]*";
        String cpfRegex = "(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)";

        if (client.getName() == null || !client.getName().matches(nameRegex)) {
            // throw new Exception("Invalid name!");
        }

        if (client.getCpf() == null || !client.getCpf().matches(cpfRegex)) {
            // throw new Exception("Invalid cpf!");
        }

        if (client.getAddress() == null) {
            // throw new Exception("Invalid address!");
        }

        if (client.getCity() == null) {
            // throw new Exception("Invalid city!");
        }

        if (client.getState() == null) {
            // throw new Exception("Invalid state!");
        }

        Client insertedClient = clientRepository.saveClient(client);

        return new ClientDto(insertedClient);
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
