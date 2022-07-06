package com.dh.mercadolivre.desafiospring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public void saveAllProducts(@RequestBody AllVeiculos allVeiculos) {

    }
}


