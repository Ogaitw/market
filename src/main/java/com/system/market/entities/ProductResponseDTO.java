package com.system.market.entities;

import java.util.Date;

public record ProductResponseDTO(Long Id, String name, Double preco, Long quantidade, Date validade) {
    public ProductResponseDTO(Product product) {
        this(product.getId(),product.getName(),product.getPreco(),product.getQuantidade(),product.getValidade());
    }
}
