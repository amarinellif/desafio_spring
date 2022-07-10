package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.model.PurchaseRequest;
import com.dh.mercadolivre.desafiospring.model.Ticket;

import java.util.List;

/**
 * Interface that implement a method that receive a list of purchase requests and returns
 * a list of tickets (all the information of the purchase requests).
 * @author Rafael Cavalcante
 * @version 0.0.1
 */
public interface ITicketService {

    /**
     * Implements the method on Tickets Service file.
     * @param ticketList receive a list of purchase requests.
     * @return a list of objects of type PurchaseRequest.
     */
    Ticket requestTicket(List<PurchaseRequest> ticketList);
}
