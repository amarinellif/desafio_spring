package com.dh.mercadolivre.desafiospring.dto;

import com.dh.mercadolivre.desafiospring.model.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.address = client.getAddress();
        this.city = client.getCity();
        this.state = client.getState();
    }
}