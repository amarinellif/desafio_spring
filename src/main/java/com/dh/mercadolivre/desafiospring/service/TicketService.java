package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.model.PurchaseRequest;
import com.dh.mercadolivre.desafiospring.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private ProductService productRepo;

    @Override
    public Ticket requestTicket(List<PurchaseRequest> ticketList) {
        return null;
    }
}
