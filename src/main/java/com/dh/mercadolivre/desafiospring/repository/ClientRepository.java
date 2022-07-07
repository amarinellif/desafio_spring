package com.dh.mercadolivre.desafiospring.repository;

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

@Repository
public class ClientRepository {
    private final String filePath = "src/main/resources/client.json";

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
        }

        List<Client> clientAlreadyExists = copyList
                .stream()
                .filter(currentClient -> currentClient.getCpf() == client.getCpf())
                .collect(Collectors.toList());

        if (clientAlreadyExists.size() > 0) {
            // throw new Exception("Client already exists!");
        }

        copyList.add(client);

        try {
            writer.writeValue(new File(filePath), copyList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return client;
    }
}
