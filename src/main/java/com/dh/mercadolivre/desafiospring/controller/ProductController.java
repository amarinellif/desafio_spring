package com.dh.mercadolivre.desafiospring.controller;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProductDto>> saveProductList(@RequestBody List<Product> productList) {
        List<ProductDto> updatedProductList = productService.saveProductList(productList);

        return new ResponseEntity<List<ProductDto>>(updatedProductList, HttpStatus.OK);
    }

    @PostMapping("/insert-article-request")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody Product product) {
        ProductDto productDto = productService.saveProduct(product);

        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }
}


