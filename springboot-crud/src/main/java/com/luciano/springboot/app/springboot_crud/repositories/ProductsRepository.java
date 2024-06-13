package com.luciano.springboot.app.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luciano.springboot.app.springboot_crud.entities.Product;

public interface ProductsRepository extends CrudRepository<Product,Long> {

}
