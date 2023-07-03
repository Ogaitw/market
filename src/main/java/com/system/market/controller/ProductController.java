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
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @GetMapping("/name/{name}")
//    public Optional<Product> findByname(@PathVariable String name ) {
//        Optional<Product> getName = producRepository.findByName(name);
//        return getName;
//    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/id/{id}")
    public Optional<Product> findById(@PathVariable Long id ) {
        Optional<Product> getId = producRepository.findById(id);
        return getId;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/edit/{id}")
    public ResponseEntity<Product> updateEmployee(@PathVariable Long id, @RequestBody ProductRequestDTO data) {
        Optional<Product> optionalEmployee = producRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Product product = optionalEmployee.get();

            if (data.name() != null) {
                product.setName(data.name());
            }
            if (data.preco()!= null) {
                product.setPreco(data.preco());
            }
            if (data.validade()!= null) {
                product.setValidade(data.validade());
            }
            if (data.quantidade()!= null) {
                product.setQuantidade(data.quantidade());
            }

            producRepository.save(product);

            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}