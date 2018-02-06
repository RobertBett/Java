package com.example.java_b.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.java_b.models.Product;
import com.example.java_b.services.ProductService;
import com.example.java_b.services.UserService;
import com.example.java_b.validator.UserValidator;

@Controller
public class Packages {
    private UserService userService;
    private ProductService productService;
    
    private UserValidator userValidator;
    
    // NEW
    public Packages(UserService userService, UserValidator userValidator, ProductService productService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.productService = productService;
    }
	
	@PostMapping("/create/package")
	public String createPage(@RequestParam("packageName") String packageName, @RequestParam("cost") Double cost) {
	   
	     Product product = new Product();
		
		product.setName(packageName);
		product.setCost(cost);
		
		productService.create(product);
		productService.update(product);
		
		return "redirect:/admin";
	}
	
	 @RequestMapping("/delete/product/{id}")
	 public String removeRing(@PathVariable Long id, Model model) {
		 Product ring = productService.getProduct(id);
		 productService.destroy(ring.getId());
		 return "redirect:/admin";
	 }

	 @RequestMapping("/activation/{id}")
	 public String activate(@PathVariable Long id, Model model) {
		 Product product = productService.getProduct(id);
		 if(product.isActivate() == true) {
			 product.setActivate(false);
			 productService.update(product);
			 System.out.println(product.isActivate());
		 }
		 else if(product.isActivate() == false) {
			 product.setActivate(true);
			 productService.update(product);
			 System.out.println(product.isActivate());
		 }
		 
		 return "redirect:/admin";
	 }
	 
	 
}
