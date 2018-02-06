package com.example.productsncategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.productsncategories.models.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{

}
