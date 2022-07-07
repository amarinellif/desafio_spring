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

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.address = client.getAddress();
    }
}