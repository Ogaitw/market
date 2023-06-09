package com.system.market.entities;

import java.util.Date;

public record ProductRequestDTO(String name, Double preco, Long quantidade, Date validade ) {

}
