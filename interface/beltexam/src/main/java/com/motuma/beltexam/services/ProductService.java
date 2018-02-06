package com.motuma.beltexam.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motuma.beltexam.models.Product;
import com.motuma.beltexam.repositories.ProductRepository;



@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public void create(Product product) {
		productRepo.save(product);
	}

	public ArrayList<Product> getProducts(){
		return (ArrayList<Product>) productRepo.findAll();
		
	}
	public Product getProduct(long id) {
		return (Product) productRepo.findOne(id);
	}
	public void update(Product product) {
		productRepo.save(product);
	}
	public void destroy(long id) {
		productRepo.delete(id);
	}
	
}
