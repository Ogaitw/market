package com.system.market.service;

import com.system.market.entities.Employee;
import com.system.market.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImplent implements MarketService {

        @Autowired
        MarketRepository marketRepository;
        @Override
        public List<Employee> findAll() {
            return marketRepository.findAll();
        }

        @Override
        public Employee findById(Long id) {
            return marketRepository.findById(id).get();
        }

        @Override
        public Employee save(Employee employee) {
            return marketRepository.save(employee);
        }




}
