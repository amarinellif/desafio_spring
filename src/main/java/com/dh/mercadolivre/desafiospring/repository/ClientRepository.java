package com.dh.mercadolivre.desafiospring.repository;

import com.dh.mercadolivre.desafiospring.exceptions.ClientAlreadyExistsException;
import com.dh.mercadolivre.desafiospring.exceptions.ClientNotFoundException;
import com.dh.mercadolivre.desafiospring.exceptions.ServerException;
import com.dh.mercadolivre.desafiospring.model.Client;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Repository
public class ClientRepository {
    private final String filePath = "src/main/resources/client.json";

    /**
     *
     * @param client
     * @return
     */
    public Client saveClient(Client client) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Client> clientList = null;
        ArrayList<Client> copyList = null;

        try {
            clientList = Arrays.asList(mapper.readValue(new File(filePath), Client[].class));
            copyList = new ArrayList<Client>(clientList);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ServerException("Could not read the given file.");
        }

        List<Client> clientAlreadyExists = copyList
                .stream()
                .filter(currentClient -> currentClient.getCpf().equals(client.getCpf()))
                .collect(Collectors.toList());


        if (clientAlreadyExists.size() > 0) {
            throw new ClientAlreadyExistsException("Client already exists.");
        }

        copyList.add(client);

        try {
            writer.writeValue(new File(filePath), copyList);
        } catch (Exception e) {
            throw new ServerException("Could not write the given file.");
        }

        return client;
    }

    /**
     *
     * @return
     */
    public List<Client> getAllClient() {
        ObjectMapper mapper = new ObjectMapper();

        List<Client> clientList = null;

        try {
            clientList = Arrays.asList(mapper.readValue(new File(filePath), Client[].class));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ServerException("Could not read the given file.");
        }

        return clientList;
    }

    /**
     *
     * @param state
     * @return
     */
    public List<Client> getClientFilteredByState(String state) {
        ObjectMapper mapper = new ObjectMapper();

        List<Client> clientList = null;

        try {
            clientList = Arrays.asList(mapper.readValue(new File(filePath), Client[].class));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ServerException("Could not read the given file.");
        }

        List<Client> filteredClientList = clientList
                .stream()
                .filter(client -> client.getState().equals(state))
                .collect(Collectors.toList());

        if (clientList.size() == 0) {
            throw new ClientNotFoundException("No client found for this state.");
        }

        return filteredClientList;
    }
}
