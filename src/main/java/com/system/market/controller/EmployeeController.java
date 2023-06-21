package com.system.market.controller;

import com.system.market.entities.Employee;
import com.system.market.entities.EmployeeRequestDTO;
import com.system.market.entities.EmployeeResponseDTO;
import com.system.market.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        List<EmployeeResponseDTO> employeeList = employeeRepository.findAll().stream().map(EmployeeResponseDTO::new).toList();
        return employeeList;
    }

    @GetMapping("/cpf/{cpf}")
    public Optional<Employee> findByCpf(@PathVariable Long cpf ) {
        Optional<Employee> getCpf = employeeRepository.findByCpf(cpf);
        return getCpf;
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Employee> deleteID(@PathVariable Long id ) {
        var product = employeeRepository.findById(id);
        employeeRepository.delete(product.get());
        return ResponseEntity.ok().body(product.get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void save(@RequestBody EmployeeRequestDTO data) {
        Employee employeeData = new Employee(data);
        employeeRepository.save(employeeData);
         
    }
}