package com.luciano.springboot.app.springboot_crud.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luciano.springboot.app.springboot_crud.entities.Product;
import com.luciano.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public ResponseEntity<?> findAllPorducts(){

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){

        Optional<Product> productOptional =  service.findById(id);

        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping //El bindingResult debe estar a continuacion del argumento que se quiere validar.
    public ResponseEntity<?> create(@Valid @RequestBody Product product,BindingResult result){

        if(result.hasFieldErrors()){
            return validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Product product,BindingResult result){

        if(result.hasFieldErrors()){
            return validation(result);
        }

        Optional<Product> optionalproduct = service.update(product,id);

        if(optionalproduct.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(optionalproduct.orElseThrow());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Optional<Product> productOptional =  service.delete(id);

        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {

        Map<String,String> erros = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            erros.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(erros);

    }

}
