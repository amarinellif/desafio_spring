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
     *
     * @param client
     * @return
     */
    @PostMapping("/client")
    public ResponseEntity<ClientDto> saveClient(@RequestBody Client client) {
        ClientDto insertedClient = clientService.saveClient(client);

        return new ResponseEntity<>(insertedClient, HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping("/client")
    public ResponseEntity<List<ClientDto>> getAllClient() {
        List<ClientDto> clientList = clientService.getAllClient();

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    /**
     *
     * @param state
     * @return
     */
    @GetMapping("/client/{state}")
    public ResponseEntity<List<ClientDto>> getClientFilteredByState(@PathVariable String state) {
        List<ClientDto> clientList = clientService.getClientFilteredByState(state);

        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }
}
