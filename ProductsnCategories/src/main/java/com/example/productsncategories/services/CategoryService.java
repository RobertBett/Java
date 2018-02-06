package com.example.productsncategories.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productsncategories.models.Category;
import com.example.productsncategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public ArrayList<Category> all(){
		return(ArrayList<Category>) categoryRepository.findAll();
	}
	public Category getById(long id) {
		return categoryRepository.findOne(id);
	}
	
	public void create(Category category) {
		categoryRepository.save(category);
	}
	
	public void update(Category category) {
		categoryRepository.save(category);
	}
	
	public void  destroy(long id) {
		categoryRepository.delete(id);
	}
	
}
