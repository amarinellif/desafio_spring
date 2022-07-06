package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ArrayList<ProductDto> saveProduct(ArrayList<Product> productList) {


    }
}
