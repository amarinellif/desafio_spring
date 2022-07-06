package com.dh.mercadolivre.desafiospring.controller;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> productList) {
        List<ProductDto> updatedProductList = productService.saveProduct(productList);

        return new ResponseEntity(updatedProductList, HttpStatus.OK);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> listProducts = productService.getAllProducts();
        return new ResponseEntity<>(listProducts, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List <ProductDto>> getProductsByCategory(@RequestParam("category") String category) {
        List<ProductDto> listProductsByCategory = productService.getProductsByCategory(category);
        return new ResponseEntity<>(listProductsByCategory, HttpStatus.OK);
    }
}


