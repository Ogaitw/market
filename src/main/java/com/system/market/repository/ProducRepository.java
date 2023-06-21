package com.system.market.repository;

import com.system.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProducRepository  extends JpaRepository <Product, Long> {

    Optional<Product> findByName(String Name);


}
