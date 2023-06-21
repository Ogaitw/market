package com.system.market.repository;

import com.system.market.entities.Employee;
import com.system.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository <Employee,Long>{
    Optional<Employee> findByCpf(Long cpf);
}
