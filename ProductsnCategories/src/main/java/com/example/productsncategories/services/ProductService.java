package com.example.productsncategories.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.productsncategories.models.Category;
import com.example.productsncategories.models.Product;
import com.example.productsncategories.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	private CategoryService categoryService;
	
	public ProductService(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	

	public ArrayList<Product> all(){
		return (ArrayList<Product>) productRepository.findAll();
	}
	
	public Product getById(long id) {
		return productRepository.findOne(id);
	}
	public ArrayList<Product> exclude(){
		ArrayList<Product> products = this.all();
		ArrayList<Category> categories = categoryService.all();
		
		for(int i=0;i<products.size();i++){
			for(int j=0;j<categories.size();j++){
				if(products.get(i) == categories.get(j).getProducts().get(j)){
					products.remove(i);
				}
			}
		}
		
		return products;
	}
	
	public void create(Product product) {
		productRepository.save(product);
	}
	
	public void update(Product product) {
		productRepository.save(product);
	}
	
	public void destory(long id) {
		productRepository.delete(id);
	}
	
}
