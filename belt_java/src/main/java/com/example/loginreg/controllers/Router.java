package com.example.loginreg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.loginreg.models.User;

@Controller
@RequestMapping("/*")//to catch all non-listed routes.
public class Router {

	
	public Router() {
		
	}
	
	@RequestMapping("")
	public String redirect(HttpSession session,@ModelAttribute("user") User user) {
		 if (user.isAdmin()==true){return "admin";}
		if(session.getAttribute("id") !=null) {
			return "redirect:/dashboard";
		}else{
			return "redirect:/register";
		}
	}

}
