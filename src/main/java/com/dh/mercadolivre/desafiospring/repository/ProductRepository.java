package com.dh.mercadolivre.desafiospring.repository;

import com.dh.mercadolivre.desafiospring.exceptions.NotFoundException;
import com.dh.mercadolivre.desafiospring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final String filePath = "src/main/resources/product.json";

    public List<Product> saveProductList(List<Product> productList) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Product> currentProductList = null;
        List<Product> currentProductCopyList = null;

        try {
            currentProductList = Arrays.asList(mapper.readValue(new File(filePath), Product[].class));
            currentProductCopyList = new ArrayList<Product>(currentProductList);

            for (Product currentProduct : productList) {
                this.insertProduct(currentProductCopyList, currentProduct);
            }

            writer.writeValue(new File(filePath), currentProductCopyList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return currentProductCopyList;
    }

    public Product saveProduct(Product product) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Product> productList = null;

        try {
            productList = Arrays.asList(mapper.readValue(new File(filePath), Product[].class));

            List<Product> finalProductList = this.insertProduct(new ArrayList<Product>(productList), product);

            writer.writeValue(new File(filePath), finalProductList);

            List<Product> updatedProduct = finalProductList
                    .stream()
                    .filter(product1 -> product.getProductId() == product1.getProductId())
                    .collect(Collectors.toList());

            product.setQuantity(updatedProduct.get(0).getQuantity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    public List<Product> insertProduct(List<Product> productList, Product product) {
        List<Product> hasProduct = productList
                .stream()
                .filter(existentProduct -> product.getProductId() == existentProduct.getProductId())
                .collect(Collectors.toList());

        if (hasProduct.size() != 0) {
            Product productToBeUpdated = hasProduct.get(0);

            int finalQuantity = productToBeUpdated.getQuantity() + product.getQuantity();

            productToBeUpdated.setQuantity(finalQuantity);
        } else {
            productList.add(product);
        }

        return productList;
    }

    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> listProducts = null;
        try {
            listProducts = Arrays.asList
                    (mapper.readValue(new File(filePath), Product[].class));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return listProducts;
    }

    public Product getProductById(Long productId) {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> lista = null;

        try {
            lista = Arrays.asList
                    (mapper.readValue(new File(filePath), Product[].class));
        } catch (Exception ex) {

        }

        for (Product p : lista) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        
        // throw new NotFoundException("Produto inexistente");
        return null;
    }
}
