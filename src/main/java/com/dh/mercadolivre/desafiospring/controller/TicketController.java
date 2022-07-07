package com.dh.mercadolivre.desafiospring.controller;


import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.model.PurchaseRequest;
import com.dh.mercadolivre.desafiospring.model.Ticket;
import com.dh.mercadolivre.desafiospring.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping("purchase-request")
    public ResponseEntity<Ticket> requestTicket(List<PurchaseRequest> ticketList){
       return null;
    }
}
