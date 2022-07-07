package com.dh.mercadolivre.desafiospring.service;

import com.dh.mercadolivre.desafiospring.dto.ProductDto;
import com.dh.mercadolivre.desafiospring.model.Product;
import com.dh.mercadolivre.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> saveProductList(List<Product> productList) {
        List<Product> updatedProductList = productRepository.saveProductList(productList);

        return updatedProductList.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }


    @Override
    public ProductDto saveProduct(Product product) {
        Product insertedProduct = productRepository.saveProduct(product);

        return new ProductDto(insertedProduct);
    }

    @Override
    public List<ProductDto> getProductsByCategory(String category) {
        List<Product> productsList = productRepository.getAllProducts();
        return productsList.stream()
                .filter(product -> product.getCategory().equals(category))
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

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

    private static List<Product> filterByCategoryName(List<Product> productList, String category) {

        return productList.stream().filter((product) -> category.equals(product.getCategory())).collect(Collectors.toList());
    }

    private static List<Product> filterByFreeShipping(List<Product> productList, Boolean freeShipping) {
        return productList.stream().filter((product) -> freeShipping.equals(product.getFreeShipping())).collect(Collectors.toList());
    }

    private static List<Product> filterByPrestige(List<Product> productList, String prestige) {
        return productList.stream().filter((product) -> prestige.equals(product.getPrestige())).collect(Collectors.toList());
    }

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
