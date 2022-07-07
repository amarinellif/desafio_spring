package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();

    List<ProductDto> saveProductList(List<Product> productList);
    
    ProductDto saveProduct(Product product);
}
