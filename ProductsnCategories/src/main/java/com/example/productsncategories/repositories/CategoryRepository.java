package com.example.productsncategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.productsncategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
