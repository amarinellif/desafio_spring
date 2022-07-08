package com.dh.mercadolivre.desafiospring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private int id;
    private String name;
    private String cpf;
    private String address;
    private String city;
    private String state;
}