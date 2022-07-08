package com.dh.mercadolivre.desafiospring.controller;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that receives the requests of the client and returns the data.
 * @author Thiago Guimarães, Thiago Frozzi, Gabriela Azevedo, Diovana Valim, Rafael Cavalcante e Amanda Marinelli
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    /**
     * Dependency Injection of the Product Service.
     */
    @Autowired
    private ProductService productService;

    /**
     * Method that calls the endpoint to register a list of products through the endpoint "/api/v1/insert-article-request.
     * @param productList received by request body.
     * @return a list of objects of type Product to the client.
     */
    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProductDto>> saveProductList(@RequestBody List<Product> productList) {
        List<ProductDto> updatedProductList = productService.saveProductList(productList);

        return new ResponseEntity<>(updatedProductList, HttpStatus.OK);
    }

    /**
     * Method to register one single product through the endpoint "/api/v1/insert-article-request.
     * @param product passed by request body.
     * @return a single object of type ProductDto to the client.
     */
    @PostMapping("/insert-article-request")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody Product product) {
        ProductDto productDto = productService.saveProduct(product);

        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    /**
     * Method to get a list of product by category through the endpoint "/api/v1/articles/{category}".
     * @param category received by url variable.
     * @return a list of products of type ProductDto filtered by category name.
     */
    @GetMapping("/articles/{category}")
    public ResponseEntity<List <ProductDto>> getProductsByCategory(@PathVariable String category) {
        List<ProductDto> listProductsByCategory = productService.getProductsByCategory(category);
        return new ResponseEntity<>(listProductsByCategory, HttpStatus.OK);
    }

    /**
     * Method that combine filters a list of objects of type Product through the endpoint "/api/v1/articles".
     * @param category received by request parameter.
     * @param freeShipping received by request parameter.
     * @param prestige received by request parameter.
     * @param order received by request parameter.
     * @return a list of objects of type ProductDto filtered according the request parameters.
     */
    @GetMapping("/articles")
    public ResponseEntity<List<ProductDto>> getByFilterOrdered(@RequestParam(required = false) String category,
                                                               @RequestParam(required = false) Boolean freeShipping,
                                                               @RequestParam(required = false) String prestige,
                                                               @RequestParam(required = false) Integer order) {
        List<ProductDto> filteredList = productService.getByFilterOrdered(category, freeShipping, prestige, order);

            return new ResponseEntity<>(filteredList, HttpStatus.OK);
    }
}


