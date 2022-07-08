package com.dh.mercadolivre.desafiospring.controller;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.model.Client;
import com.dh.mercadolivre.desafiospring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that receives the requests of the client and returns the data.
 * @author Diovana Valim
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
public class ClientController {

    /**
     * Dependency Injection of the Client Service.
     */
    @Autowired
    private ClientService clientService;

    /**
     * Method to register one single client through the endpoint "/api/v1/client".
     * @param client object of type Client.
     * @return a single object of type ClientDto writed on client.json file.
     */
    @PostMapping("/client")
    public ResponseEntity<ClientDto> saveClient(@RequestBody Client client) {
        ClientDto insertedClient = clientService.saveClient(client);

        return new ResponseEntity<>(insertedClient, HttpStatus.OK);
    }

    /**
     * Method that gets a list of objects of type Client through the endpoint "/api/v1/client".
     * @return a list of objects of type ClientDto writed on client.json file.
     */
    @GetMapping("/client")
    public ResponseEntity<List<ClientDto>> getAllClient() {
        List<ClientDto> clientList = clientService.getAllClient();

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    /**
     * Method that filter the clients by state.
     * @param state passed by url variable.
     * @return a list of objects of type ClientDto filtered by state.
     */
    @GetMapping("/client/{state}")
    public ResponseEntity<List<ClientDto>> getClientFilteredByState(@PathVariable String state) {
        List<ClientDto> clientList = clientService.getClientFilteredByState(state);

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }
}
