package com.system.market.repository;

import com.system.market.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository <Employee,Long>{
}
