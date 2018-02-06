package com.motuma.beltexam.controllers;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motuma.beltexam.models.Product;
import com.motuma.beltexam.models.Role;
import com.motuma.beltexam.models.User;
import com.motuma.beltexam.services.ProductService;
import com.motuma.beltexam.services.UserService;
import com.motuma.beltexam.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    private ProductService productService;
    
    private UserValidator userValidator;
    
    // NEW
    public Users(UserService userService, UserValidator userValidator, ProductService productService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.productService = productService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "redirect:/login";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
        	return "loginPage.jsp";
        }
        if(userService.getUsers().isEmpty()) {
        	userService.saveUserWithAdminRole(user);
        	System.out.println("saved as admin user.");
        	Product currentProduct = new Product();
        	currentProduct.setCounter(0);
        	return "redirect:/login";
        }
        
        userService.saveWithUserRole(user);
        System.out.println("saved as user.");
        return "redirect:/login";
    }
     

    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        
        List<Product> products = productService.getProducts();
        List<User> customers = new ArrayList<User>();
        
        
        
        for(User user: userService.getUsers()) {
        	 for(Role role: user.getRoles()) {
             	if((role.getName().equals("ROLE_USER"))) {
             		customers.add(user);
             		System.out.println(user.getFirstName());
             	}		
             }
        }
       
        model.addAttribute("customers", customers);
        model.addAttribute("products", productService.getProducts());
        return "adminPage.jsp";
    }
    
    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }
		model.addAttribute("loginMessage", "registration Successfull. Please Login!");
		return "loginPage.jsp";
	}
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        User user=userService.findByUsername(username);
        model.addAttribute("currentUser", userService.findByUsername(username));
        for(Role role: user.getRoles()) {
        	if(role.getName().equals("ROLE_ADMIN")) {
        		System.out.println("Loging in as a admin.");
        		return "redirect:/admin";
        	}		
        }
       
        try {
        
		        if(user.getProduct().getId() != null) {
		        	model.addAttribute("products", productService.getProducts());
		        	return "profilePage.jsp";
		        }
	        
        	}catch(NullPointerException e) {
        		model.addAttribute("products", productService.getProducts());
        		return "homePage.jsp";
        	}
	    return "homePage.jsp";
       
    }
    
    
	 @PostMapping("/signup/product")
	 public String createUp(@RequestParam("product_id") long product_id, @RequestParam("duedate") int duedate, Principal principal, Model model) {
		 String username = principal.getName();
	     User user=userService.findByUsername(username);
	     model.addAttribute("currentUser", userService.findByUsername(username));
	     
	     //update counter on admin.
	     Product product = productService.getProduct(product_id);
	     product.setCounter(product.getCounter() + 1);
	     System.out.println(product.getCounter());
	     productService.update(product);
	     
	     
	     
	     // Get current date
	     Date currentDate = new Date();
	     
	     // convert date to localdatetime
	     LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	     
	     localDateTime = localDateTime.plusDays(duedate);
	     Date currentDateDuedate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	     
	     System.out.println(currentDateDuedate);
	     
	     user.setUpdatedAt(currentDateDuedate);
	    // userService.updateUse(user);
	     user.setProduct(productService.getProduct(product_id));
	     userService.updateUse(user);
	          
		 return "profilePage.jsp";
	 }
	 
}
