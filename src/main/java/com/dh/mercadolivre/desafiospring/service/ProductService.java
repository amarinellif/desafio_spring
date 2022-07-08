package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that implements the methods of the IProductService interface.
 * @author Diovana Valim, Gabriela Azevedo, Rafael Cavalcanti, Thiago Frozzi, Thiago Guimarães, Amanda Marinelli
 * @version 0.0.1
 * @see java.lang.Object
 */
@Service
public class ProductService implements IProductService {

    /**
     * Dependency Injection of the Product Repository.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Method that saves a list of products.
     * @param productList
     * @return a list of objects of type ProductDto.
     */
    @Override
    public List<ProductDto> saveProductList(List<Product> productList) {
        List<Product> updatedProductList = productRepository.saveProductList(productList);

        return updatedProductList.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Method for to save a one product at a time.
     * @param product receives an object of type Product.
     * @return return a object of type ProductDto.
     */
    @Override
    public ProductDto saveProduct(Product product) {
        Product insertedProduct = productRepository.saveProduct(product);

        return new ProductDto(insertedProduct);
    }

    /**
     * Method that filters a products list by category name.
     * @param category
     * @return a list of objects of type Products filtered by category name.
     */
    @Override
    public List<ProductDto> getProductsByCategory(String category) {
        List<Product> productsList = productRepository.getAllProducts();
        return productsList.stream()
                .filter(product -> product.getCategory().equals(category))
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Method that implements filters by category, free shipping, prestige, order through the conditional statements.
     * @param category category of the product.
     * @param freeShipping if the product has or hasn't free shipping.
     * @param prestige classifies the product by acceptance.
     * @param order filter by order, crescent or descending.
     * @return a list of products of type ProductDto.
     */
    public List<ProductDto> getByFilterOrdered(String category, Boolean freeShipping, String prestige, Integer order) {
        List<Product> listProducts = productRepository.getAllProducts();

        if (category != null) {
            listProducts = filterByCategoryName(listProducts, category);
        }

        if (freeShipping != null) {
            listProducts = filterByFreeShipping(listProducts, freeShipping);
        }

        if (prestige != null) {
            listProducts = filterByPrestige(listProducts, prestige);
        }

        if (order != null) {
            listProducts = sortByOrder(listProducts, order);
        }

        List<ProductDto> listDto = listProducts.stream()
                .map(ProductDto::new).collect(Collectors.toList());

        return listDto;

    }

    /**
     * Filter the products by category name.
     * @param productList
     * @param category
     * @return a list of the products of type Product filtered by category name.
     */
    private static List<Product> filterByCategoryName(List<Product> productList, String category) {

        return productList.stream().filter((product) -> category.equals(product.getCategory())).collect(Collectors.toList());
    }

    /**
     * Filter the products by free shipping.
     * @param productList
     * @param freeShipping
     * @return a list of the products of type Product filtered by free shipping.
     */
    private static List<Product> filterByFreeShipping(List<Product> productList, Boolean freeShipping) {
        return productList.stream().filter((product) -> freeShipping.equals(product.getFreeShipping())).collect(Collectors.toList());
    }

    /**
     * Filter the products by prestige.
     * @param productList
     * @param prestige
     * @return a list of the products of type Product filtered by prestige.
     */
    private static List<Product> filterByPrestige(List<Product> productList, String prestige) {
        return productList.stream().filter((product) -> prestige.equals(product.getPrestige())).collect(Collectors.toList());
    }

    /**
     * Method that sort the products by name and price (crescent or descending).
     * @param productList
     * @param order
     * @return a list of the products of type Product sorted.
     */
    private static List<Product> sortByOrder(List<Product> productList, Integer order) {
        switch (order) {
            case 0:
                return productList.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
            case 1:
                return productList.stream().sorted((p1, p2) -> p2.getName().compareTo(p1.getName())).collect(Collectors.toList());
            case 2:
                return productList.stream().sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice())).collect(Collectors.toList());
            case 3:
                return productList.stream().sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice())).collect(Collectors.toList());
            default:
                return productList;
        }
    }
}
