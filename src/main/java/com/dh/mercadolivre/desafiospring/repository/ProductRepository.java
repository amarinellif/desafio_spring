package com.dh.mercadolivre.desafiospring.repository;

import com.dh.mercadolivre.desafiospring.exceptions.NotFoundException;
import com.dh.mercadolivre.desafiospring.exceptions.ServerException;
import com.dh.mercadolivre.desafiospring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import javax.imageio.IIOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                copyList.add(productList.get(i));
            }

            writer.writeValue(new File(filePath), copyList);
        } catch (IIOException e) {
            System.out.println("Erro no aquivo: " + filePath);
            throw new ServerException("Algo de errado aconteceu. Tente novamente mais tarde.");
        } catch (Exception ex) {
            throw new ServerException("Algo de errado aconteceu. Tente novamente mais tarde.");
        }

        return copyList;
    }

    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> listProducts = null;
        try {
            listProducts = Arrays.asList
                    (mapper.readValue(new File(filePath), Product[].class));
        } catch (IIOException e) {
            System.out.println("Erro no aquivo: " + filePath);
            throw new ServerException("Algo de errado aconteceu. Tente novamente mais tarde.");
        } catch (Exception ex) {
            throw new ServerException("Algo de errado aconteceu. Tente novamente mais tarde.");
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
        } catch (IIOException e) {
            System.out.println("Erro no aquivo: " + filePath);
            throw new ServerException("Algo de errado aconteceu. Tente novamente mais tarde.");
        } catch (Exception ex) {
            throw new ServerException("Algo de errado aconteceu. Tente novamente mais tarde.");
        }

        return product;
    }
}
