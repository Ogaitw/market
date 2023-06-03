package com.system.market.controller;

import com.system.market.entities.Employee;
import com.system.market.entities.EmployeeRequestDTO;
import com.system.market.entities.EmployeeResponseDTO;
import com.system.market.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Employee")
public class EmployeeController {

    @Autowired
    MarketRepository marketRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        List<EmployeeResponseDTO> employeeList = marketRepository.findAll().stream().map(EmployeeResponseDTO::new).toList();
        return employeeList;
    }

//    @GetMapping
//    public Employee findById(Long id) {
//        Employee getId = marketRepository.findById(id).get();
//        return getId;
//    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void save(@RequestBody EmployeeRequestDTO data) {
        Employee employeeData = new Employee(data);
        marketRepository.save(employeeData);
         
    }
}