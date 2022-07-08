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
import java.util.stream.Collectors;

/**
 * Class ProductRepository that will do the persistence of the data.
 * Receive an attribute path that indicates a path for to save product.json file.
 * Will read and save the data through the POST request.
 * @author Diovana Valim, Amanda Marinelli e Rafael Cavalcante
 * @version 0.0.1
 * @see java.lang.Object
 */

@Repository
public class ProductRepository {
    private final String filePath = "src/main/resources/product.json";

    /**
     * Method that receive a list of type Product. This method will read the data, write and save the return on a product.json file.
     * @param productList
     * @throws ServerException - in case of error on action of read and write the data.
     * @return a list of objects of type Products on products.json file.
     */
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
        } catch (IIOException e) {
            System.out.println(e.getMessage());

            throw new ServerException(String.format("Could not write or read file %s", filePath));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ServerException("Something went wrong.");
        }

        return currentProductCopyList;
    }

    /**
     * Method that receive one object of type Product. This method will read the data, write and save the return on a product.json file.
     * @param product receive an object of type Product.
     * @exception - in case of error on action of read and write the data.
     * @return an object product of type Product.
     */
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

            throw new ServerException("Something went wrong.");
        }

        return product;
    }

    /**
     * Method that verifies if the product already exists on the product.json file.
     * If not exists insert (write) the data on the product.json file.
     * If exists increments the quantity of the product.
     * @param productList list of objects of type Product
     * @param product object of type Product
     * @return an updated list of objects of type Products on products.json file.
     */
    public List<Product> insertProduct(List<Product> productList, Product product) {
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ServerException("Something went wrong.");
        }
    }

    /**
     * Method for read the product.json and get a list of products and return on a request GET.
     * @throws ServerException
     * @return a list of products of type Product.
     */
    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> listProducts = null;
        try {
            listProducts = Arrays.asList
                    (mapper.readValue(new File(filePath), Product[].class));
        } catch (IIOException e) {
            System.out.println(e.getMessage());

            throw new ServerException(String.format("Could not read file %s", filePath));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ServerException("Something went wrong.");
        }
        
        return listProducts;
    }

    /**
     * Method for read the file and get product filtering by id.
     * @param productId receive the productId attribute.
     * @throws ServerException
     * @return an object product of type Product.
     */
    public Product getProductById(Long productId) {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> list = null;

        try {
            list = Arrays.asList
                    (mapper.readValue(new File(filePath), Product[].class));
        } catch (IIOException e) {
            System.out.println(e.getMessage());

            throw new ServerException(String.format("Could not read file %s", filePath));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ServerException("Something went wrong.");
        }

        for (Product p : list) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        
        throw new NotFoundException("No product found.");
    }

    /**
     * a method to update the quantity of a product in the database
     * @param productId
     * @param quantity
     */
    public void updateQuantity(Long productId, Integer quantity){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Product> list = null;

        try {
            list = Arrays.asList
                    (mapper.readValue(new File(filePath), Product[].class));

            List<Product> copyList = new ArrayList<Product>(list);

            for (Product p : copyList) {
                if (p.getProductId().equals(productId)) {
                    p.setQuantity(p.getQuantity() - quantity);
                }
            }

            writer.writeValue(new File(filePath), copyList);

        } catch (IIOException e) {
            System.out.println(e.getMessage());

            throw new ServerException(String.format("Could not read or write file %s", filePath));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ServerException("Something went wrong.");
        }

    }

}
