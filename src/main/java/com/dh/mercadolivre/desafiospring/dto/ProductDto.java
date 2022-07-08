package com.dh.mercadolivre.desafiospring.dto;

import com.dh.mercadolivre.desafiospring.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 */
@Getter

/**
 *
 */
@Setter

/**
 *
 */
@NoArgsConstructor
/**
 *
 */
public class ProductDto {
    private Long productId;
    private String name;
    private Integer quantity;

    /**
     *
     * @param product
     */
    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }
}
