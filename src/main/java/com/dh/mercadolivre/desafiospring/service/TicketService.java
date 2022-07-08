package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.model.PurchaseRequest;
import com.dh.mercadolivre.desafiospring.model.Ticket;
import com.dh.mercadolivre.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the methods of the ITicketService Interface
 * @author  Rafael Cavalcante
 * @version 0.0.1
 */
@Service
public class TicketService implements ITicketService{

    /**
     * Dependency Injection of the Product Repository.
     */
    @Autowired
    private ProductRepository productRepo;

    /**
     * Method tha receives a ticket list of type Purchase Request that returns a list of tickets
     * with the total of the purchase updated.
     * @param ticketList receive a list of purchase requests.
     * @return a list of tickets of type PurchaseRequest with the attribute total updated.
     */
    @Override
    public Ticket requestTicket(List<PurchaseRequest> ticketList) {
        List<Product> productlist = new ArrayList<Product>();
        double total = 0;
        for (PurchaseRequest t : ticketList){
            Product p = productRepo.getProductById(t.getProductId());
            productlist.add(p);
            total = total + p.getPrice() * t.getQuantity();
        }

        Ticket ticket = new Ticket(3, productlist, total);

        return ticket;
    }
}
