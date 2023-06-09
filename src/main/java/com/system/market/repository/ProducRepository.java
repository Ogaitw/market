package com.system.market.repository;

import com.system.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducRepository  extends JpaRepository <Product, Long> {
}
