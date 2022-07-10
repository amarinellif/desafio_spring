package com.dh.mercadolivre.desafiospring.dto;

import com.dh.mercadolivre.desafiospring.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Method Getter implemented by Lombok lib for get access the private attributes of the Product Class
 */
@Getter

/**
 * Method Setter implemented by Lombok lib for set the private attributes of the Product Class
 */
@Setter

/**
 * Method Default Constructor implemented by Lombok lib
 */
@NoArgsConstructor

/**
 *class for a data tranfers Object for the class of Product
 * @author Gabriela Azevedo
 * @version 0.0.1
 * @see java.lang.Object
 */
public class ProductDto {
    private Long productId;
    private String name;
    private Integer quantity;

    /**
     * method for constructing an Product Dto from a Product
     * @param product
     */
    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }
}
