package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.exceptions.InvalidParamsException;
import com.dh.mercadolivre.desafiospring.model.Client;
import com.dh.mercadolivre.desafiospring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class ClientService implements IClientService {

    /**
     *
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     *
     * @param client
     * @return
     */
    @Override
    public ClientDto saveClient(Client client) {
        String nameRegex = "[A-Z][a-z]* [A-Z][a-z]*";
        String cpfRegex = "(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)";

        if (client.getName() == null || !client.getName().matches(nameRegex)) {
             throw new InvalidParamsException("Invalid name param");
        }

        if (client.getCpf() == null || !client.getCpf().matches(cpfRegex)) {
            throw new InvalidParamsException("Invalid CPF param");
        }

        if (client.getAddress() == null) {
            throw new InvalidParamsException("Invalid address param");
        }

        if (client.getCity() == null) {
            throw new InvalidParamsException("Invalid city param");
        }

        if (client.getState() == null) {
            throw new InvalidParamsException("Invalid state param");
        }

        Client insertedClient = clientRepository.saveClient(client);

        return new ClientDto(insertedClient);
    }

    /**
     *
     * @return
     */
    @Override
    public List<ClientDto> getAllClient() {
        List<Client> clientList = clientRepository.getAllClient();

        List<ClientDto> clientDtoList = clientList
                .stream()
                .map(ClientDto::new)
                .collect(Collectors.toList());

        return clientDtoList;
    }

    /**
     *
     * @param state
     * @return
     */
    @Override
    public List<ClientDto> getClientFilteredByState(String state) {
        ArrayList<String> states = new ArrayList<String>(Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES",
                "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP",
                "SE", "TO"));

        List<String> validState = states
                .stream()
                .filter(listState -> listState.equals(state))
                .collect(Collectors.toList());

        if (validState.size() == 0) {
            throw new InvalidParamsException("Invalid state param");
        }

        List<Client> clientList = clientRepository.getClientFilteredByState(state);

        List<ClientDto> clientDtoList = clientList
                .stream()
                .map(ClientDto::new)
                .collect(Collectors.toList());

        return clientDtoList;
    }
}
