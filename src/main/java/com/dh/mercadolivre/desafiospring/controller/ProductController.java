package com.dh.mercadolivre.desafiospring.controller;

import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void saveProducts(@RequestBody ArrayList<Product> productList) {

    }
}


