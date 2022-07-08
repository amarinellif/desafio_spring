package com.dh.mercadolivre.desafiospring.controller;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.model.Client;
import com.dh.mercadolivre.desafiospring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<ClientDto> saveClient(@RequestBody Client client) {
        ClientDto insertedClient = clientService.saveClient(client);

        return new ResponseEntity<ClientDto>(insertedClient, HttpStatus.OK);
    }

    @GetMapping("/client")
    public ResponseEntity<List<ClientDto>> getAllClient() {
        List<ClientDto> clientList = clientService.getAllClient();

        return new ResponseEntity<List<ClientDto>>(clientList, HttpStatus.OK);
    }

    @GetMapping("/client/{state}")
    public ResponseEntity<List<ClientDto>> getClientFilteredByState(@PathVariable String state) {
        List<ClientDto> clientList = clientService.getClientFilteredByState(state);

        return new ResponseEntity<List<ClientDto>>(clientList, HttpStatus.OK);
    }
}
