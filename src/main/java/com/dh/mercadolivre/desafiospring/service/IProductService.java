package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;

import java.util.List;

/**
 * Interface to deal with the methods of the application.
 * @author Gabriela Azevedo, Rafael Cavalcante, Diovana Valim, Thiago Frozzi, Amanda Marinelli, Thiago Guimarães
 * @version 0.0.1
 */
public interface IProductService {

    /**
     *
     * @param category
     * @return
     */
    List<ProductDto> getProductsByCategory(String category);

    /**
     *
     * @param productList
     * @return
     */
    List<ProductDto> saveProductList(List<Product> productList);

    /**
     *
     * @param product
     * @return
     */
    ProductDto saveProduct(Product product);

    /**
     *
     * @param category
     * @param freeShipping
     * @param prestige
     * @param order
     * @return
     */
    List<ProductDto> getByFilterOrdered(String category, Boolean freeShipping, String prestige, Integer order);
}
