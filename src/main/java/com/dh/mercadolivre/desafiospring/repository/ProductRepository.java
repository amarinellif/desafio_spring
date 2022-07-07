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

        List<Product> existentProductList = null;
        List<Product> copyList = null;

        try {
            existentProductList = Arrays.asList(mapper.readValue(new File(filePath), Product[].class));
            copyList = new ArrayList<Product>(existentProductList);

            for (int i = 0; i < productList.size(); i++) {
                Product currentProduct = productList.get(i);

                List<Product> hasProduct = copyList
                        .stream()
                        .filter(product -> product.getProductId() == currentProduct.getProductId())
                        .collect(Collectors.toList());

                if (hasProduct.size() != 0) {
                    Product productToBeUpdated = hasProduct.get(0);

                    int finalQuantity = productToBeUpdated.getQuantity() + currentProduct.getQuantity();

                    productToBeUpdated.setQuantity(finalQuantity);
                } else {
                    copyList.add(productList.get(i));
                }
            }

            writer.writeValue(new File(filePath), copyList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return copyList;
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

    public Product saveProduct(Product product) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Product> productList = null;
        List<Product> copyList = null;

        try {
            productList = Arrays.asList(mapper.readValue(new File(filePath), Product[].class));

            copyList = new ArrayList<Product>(productList);

            copyList.add(product);

            writer.writeValue(new File(filePath), copyList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return product;
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
//        throw new NotFoundException("Produto inexistente");
        return null;
    }
}
