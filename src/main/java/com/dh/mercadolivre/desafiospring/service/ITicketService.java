package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.model.PurchaseRequest;
import com.dh.mercadolivre.desafiospring.model.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket requestTicket(List<PurchaseRequest> ticketList);
}
