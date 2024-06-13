package com.luciano.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import com.luciano.springboot.app.springboot_crud.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Optional<Product> update(Product product,Long id);

    Optional<Product> delete(Long id);
}
