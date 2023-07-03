package com.system.market.entities;

import java.util.Date;

public record ProductRequestDTO(Long id, String name, Double preco, Long quantidade, Date validade ) {

}
