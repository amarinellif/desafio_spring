package com.dh.mercadolivre.desafiospring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {
    private Long productId;
    private Integer quantity;
}
