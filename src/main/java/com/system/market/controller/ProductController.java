package com.system.market.controller;

import com.system.market.entities.*;
import com.system.market.repository.ProducRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProducRepository producRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProductResponseDTO> getAll() {
        List<ProductResponseDTO> productlist = producRepository.findAll().stream().map(ProductResponseDTO::new).toList();
        return productlist;
    }

    @GetMapping("/name/{name}")
    public Optional<Product> findByname(@PathVariable String name ) {
        Optional<Product> getName = producRepository.findByName(name);
        return getName;
    }
    @DeleteMapping("/id/{id}")
    public  ResponseEntity<Product>  deleteID(@PathVariable Long id ) {
        var product = producRepository.findById(id);
        producRepository.delete(product.get());
        return ResponseEntity.ok().body(product.get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void save(@RequestBody ProductRequestDTO data) {
        Product productData = new Product(data);
        producRepository.save(productData);
         
    }
}