package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> saveProduct(List<Product> productList);

    List<ProductDto> getByFilterOrdered(String category, Boolean freeShipping, String prestige, Integer order);
}
