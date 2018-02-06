package com.example.productsncategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
    @DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
    @DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;
    
    @PrePersist
    public void onCreate(){this.createdAt = new Date();}
    @PreUpdate
    public void onUpdate(){this.updatedAt = new Date();}
    
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name ="categories_products",
		joinColumns = @JoinColumn(name= "category_id"),
		inverseJoinColumns = @JoinColumn(name="product_id")
	)
	private List<Product>products;
	
	public Category() {
		
	}

	public Category(String name) {
		this.name = name;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
