package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;

import java.util.ArrayList;

public interface IProductService {
    ArrayList<ProductDto> saveProduct(ArrayList<Product> productList);
}
