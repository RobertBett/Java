package com.example.productsncategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.productsncategories.models.Category;
import com.example.productsncategories.models.Product;
import com.example.productsncategories.services.CategoryService;
import com.example.productsncategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("")
	public String categories(Model model){
		model.addAttribute("categories",categoryService.all());
		return "dashboard";
	}

	@RequestMapping("/new")
	public String _new(Model model){
		model.addAttribute("category",new Category());
		return "categories_new";
	}
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("category") Category category,BindingResult res,RedirectAttributes re){
		if(res.hasErrors()){
			re.addFlashAttribute("errs",res.getAllErrors());
		}else{
			categoryService.create(category);
		}
		
		return "redirect:/";
 	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") long id,Model model){
		model.addAttribute("category",categoryService.getById(id));
		model.addAttribute("products",productService.all());
		return "categories_show";
	}
	
	@PostMapping("/{categoryId}")
	public String add(@PathVariable("categoryId") long categoryId,@RequestParam("product") long productId){
		Category category      = categoryService.getById(categoryId);
		Product product        = productService.getById(productId);
		List<Product> products = category.getProducts();

		products.add(product);
		categoryService.update(category);
		
		return "redirect:/";
	}
}