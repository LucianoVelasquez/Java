package com.luciano.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luciano.springboot.app.springboot_crud.entities.Product;
import com.luciano.springboot.app.springboot_crud.repositories.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService {

    
    private ProductsRepository repository;

    public ProductServiceImpl(ProductsRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        List<Product> findProducts = (List<Product>) repository.findAll();

        return findProducts;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) { 

        return repository.save(product);

    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> optionalProduct = repository.findById(id); 

        optionalProduct.ifPresent(productDb -> {
            repository.delete(productDb);
        });

        return optionalProduct;
    }

    @Transactional
    @Override
    public Optional<Product> update(Product product, Long id) {
        Optional<Product> optionalProduct = repository.findById(id); 

        if(optionalProduct.isPresent()){
            Product productDb = optionalProduct.orElseThrow();

            productDb.setName(product.getName());
            productDb.setDescription(product.getDescription());
            productDb.setPrice(product.getPrice());

            return  Optional.of(repository.save(productDb));
        }
            
        return optionalProduct;
    }

}
