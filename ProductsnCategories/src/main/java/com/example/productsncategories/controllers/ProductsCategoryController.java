package com.example.productsncategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.productsncategories.services.CategoryService;
import com.example.productsncategories.services.ProductService;

@Controller
@RequestMapping("/")
public class ProductsCategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("")
	public String index(Model model){
		model.addAttribute("categories",categoryService.all());
		model.addAttribute("products", productService.all());
		return "dashboard";
	}
}