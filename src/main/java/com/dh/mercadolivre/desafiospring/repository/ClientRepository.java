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
 * Class ClientRepository that will do the persistence of the data.
 * Receive an attribute path that indicates a path for to save client.json file.
 * Will read and save the data through the POST request.
 * @author Diovana Valim
 * @version 0.0.1
 * @see java.lang.Object
 */
@Repository
public class ClientRepository {
    private final String filePath = "src/main/resources/client.json";

    /**
     * Method will read an object Client, save on cliente.json and return the same client.
     * @param client
     * @throws ServerException - in case of error on action of read and write the data.
     * @throws ClientAlreadyExistsException - in case of the client already exists.
     * @return client
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
     * Method to read the file clients.json and get the list of client and return on a request GET.
     * @throws ServerException
     * @return a clients list.
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
     * Method to read the file clients.json and get the clients list filtered by state and return on a request GET.
     * @throws ServerException
     * @throws ClientNotFoundException is called when the user requet filter the list with a state that doesn`t have registered
     * @param  state (String)
     * @return a clients list.
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
