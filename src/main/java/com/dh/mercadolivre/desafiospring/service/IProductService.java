package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;

import java.util.List;

/**
 * Interface to deal with the methods of the Product class.
 * @author Gabriela Azevedo, Rafael Cavalcante, Diovana Valim, Thiago Frozzi, Amanda Marinelli, Thiago Guimarães
 * @version 0.0.1
 */
public interface IProductService {

    /**
     * Method that gets all products filtered by category name.
     * @param category
     * @return a list of objects of type ProductDto filtered by category name.
     */
    List<ProductDto> getProductsByCategory(String category);

    /**
     * Method that read, write and save a list of products on the products.json file.
     * @param productList
     * @return a list of objects of type ProductDto.
     */
    List<ProductDto> saveProductList(List<Product> productList);

    /**
     * Method that read, write and save one single product.
     * @param product
     * @return a one single object of type ProductDto.
     */
    ProductDto saveProduct(Product product);

    /**
     * Method that implements a combined filters.
     * @param category
     * @param freeShipping
     * @param prestige
     * @param order
     * @return a list of objects of type ProductDto filtered by the parameters passed through request params.
     */
    List<ProductDto> getByFilterOrdered(String category, Boolean freeShipping, String prestige, Integer order);
}
