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
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        List<EmployeeResponseDTO> employeeList = employeeRepository.findAll().stream().map(EmployeeResponseDTO::new).toList();
        return employeeList;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/id/{id}")
    public Optional<Employee> findByID(@PathVariable Long id ) {
        Optional<Employee> getid = employeeRepository.findById(id);
        return getid;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Employee> deleteID(@PathVariable Long id ) {
        var employee = employeeRepository.findById(id);
        employeeRepository.delete(employee.get());
        return ResponseEntity.ok().body(employee.get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void save(@RequestBody EmployeeRequestDTO data) {
        Employee employeeData = new Employee(data);
        employeeRepository.save(employeeData);
         
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/edit/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO data) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            if (data.name() != null) {
                employee.setName(data.name());
            }
            if (data.email()!= null) {
                employee.setEmail(data.email());
            }
            if (data.cpf()!= null) {
                employee.setCpf(data.cpf());
            }
            if (data.shift()!= null) {
                employee.setShift(data.shift());
            }
            if (data.phone()!= null) {
                employee.setPhone(data.phone());
            }
            employeeRepository.save(employee);

            return ResponseEntity.ok().body(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}