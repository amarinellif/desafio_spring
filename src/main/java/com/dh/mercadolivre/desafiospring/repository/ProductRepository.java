package com.dh.mercadolivre.desafiospring.repository;

import com.dh.mercadolivre.desafiospring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private final String filePath = "src/main/resources/product.json";

    public List<Product> saveProduct(ArrayList<Product> productList) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Product> existentProductList = null;

        try {
            existentProductList = Arrays.asList(mapper.readValue(new File(filePath), Product[].class));

            for (int i = 0; i < productList.size(); i++) {
                existentProductList.add(productList.get(i));
            }

            writer.writeValue(new File(filePath), existentProductList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return existentProductList;
    }
}
