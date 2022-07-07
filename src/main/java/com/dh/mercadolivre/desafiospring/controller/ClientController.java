package com.dh.mercadolivre.desafiospring.controller;

import com.dh.mercadolivre.desafiospring.dto.ClientDto;
import com.dh.mercadolivre.desafiospring.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @PostMapping("/client")
    public ResponseEntity<ClientDto> saveClient(@RequestBody Client client) {}

    @GetMapping("/client")
    public ResponseEntity<List<ClientDto>> getAllClient() {}

    @GetMapping("/client/{state}")
    public ResponseEntity<List<ClientDto>> getClientFilteredByState(@RequestParam String state) {}
}
