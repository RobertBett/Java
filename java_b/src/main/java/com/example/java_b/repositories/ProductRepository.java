package com.example.java_b.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.java_b.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
