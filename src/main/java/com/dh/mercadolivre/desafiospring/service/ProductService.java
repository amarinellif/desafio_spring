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
    public List<ProductDto> getAllProducts() {
        List<Product> listProducts = productRepository.getAllProducts();
        List<ProductDto> listDto = listProducts.stream()
                                    .map(ProductDto::new).collect(Collectors.toList());

        return listDto;

    }

    @Override
    public ProductDto saveProduct(Product product) {
        Product insertedProduct = productRepository.saveProduct(product);

        return new ProductDto(insertedProduct);
    }
}
