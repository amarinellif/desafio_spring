package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.model.PurchaseRequest;
import com.dh.mercadolivre.desafiospring.model.Ticket;
import com.dh.mercadolivre.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private ProductRepository productRepo;

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
