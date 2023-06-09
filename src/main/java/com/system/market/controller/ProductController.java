package com.system.market.controller;

import com.system.market.entities.*;
import com.system.market.repository.ProducRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Product")
public class ProductController {

    @Autowired
    ProducRepository producRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProductResponseDTO> getAll() {
        List<ProductResponseDTO> productlist = producRepository.findAll().stream().map(ProductResponseDTO::new).toList();
        return productlist;
    }

//    @GetMapping
//    public Employee findById(Long id) {
//        Employee getId = marketRepository.findById(id).get();
//        return getId;
//    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void save(@RequestBody ProductRequestDTO data) {
        Product productData = new Product(data);
        producRepository.save(productData);
         
    }
}