package com.system.market.service;

import com.system.market.entities.Employee;

import java.util.List;

public interface MarketService {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

}
