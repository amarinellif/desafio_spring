package com.dh.mercadolivre.desafiospring.controller;

import com.dh.mercadolivre.desafiospring.model.PurchaseRequest;
import com.dh.mercadolivre.desafiospring.model.Ticket;
import com.dh.mercadolivre.desafiospring.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class that receives the requests of the client and returns the data.
 * @author Rafael Cavalcante
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
public class TicketController {

    /**
     * Dependency Injection of the Ticket Service.
     */
    @Autowired
    private TicketService service;

    /**
     * Method to register a list of tickets (purchase request) through the endpoint "/api/v1/purchase-request".
     * @param ticketList
     * @return a list of objects of type PurchaseRequest
     */
    @PostMapping("/purchase-request")
    public ResponseEntity<Ticket> requestTicket(@RequestBody List<PurchaseRequest> ticketList){
       Ticket ticket = service.requestTicket(ticketList);

       return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
