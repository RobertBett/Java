package com.example.loginreg.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.loginreg.models.Role;
import com.example.loginreg.models.User;
import com.example.loginreg.services.RoleService;
import com.example.loginreg.services.UserService;
import com.example.loginreg.validator.UserValidator;

@Controller
public class UserController{
	private UserService us;
	
	@Autowired
	private UserValidator uv;
	private RoleService roleService;

	public UserController(UserService us, UserValidator uv){
		this.us=us;
		this.uv=uv;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession s, Principal principal,Model model){
		User user = us.findByEmail(principal.getName());
		model.addAttribute("user",user);
		user.setUpdatedAt(new Date());
		us.update(user);
		
		if(user.isAdmin()){
			return "redirect:/admin";
		}else{
	
			return "redirect:/register";}
	
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session,RedirectAttributes flash){
		if(email.length() < 1){// Dont waste a query.
			flash.addFlashAttribute("error","Email cannot be blank.");
			return "redirect:/register";			
		}

		User user = us.findByEmail(email);

		if(user == null){
			flash.addFlashAttribute("error","No user with this email was found. You can register below");
			return "redirect:/register";
		}else{
			if(us.isMatch(password,user.getPassword())){
				us.login(session,user.getId());
				session.setAttribute( "currentUser",user);
				return "redirect:/dashboard";
			}else{
				flash.addFlashAttribute("error","Invalid Credentials");
				return "redirect:/register";								
			}
		}
	}


	@RequestMapping("/logout")
	public String logout(HttpSession s, Model model,@RequestParam(value="logout",required=false) String logout){
		if(logout != null){model.addAttribute("logoutMessage","Logout Successful");}
		s.setAttribute("id",null);
		return "redirect:/register";
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user,HttpSession s){
		s.setAttribute("id",null);
		return "register";
	}

	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("user") User user,BindingResult res,HttpSession session, Model model, @ModelAttribute("role") Role role){
		uv.validate(user, res);
		System.out.println(roleService.findByName("ROLE_USER")==null);
		if(res.hasErrors()){
			return "register";

		}else if (roleService.findByName("ROLE_ADMIN").getUsers().size() < 1) {
			us.create(new String[]{"ROLE_USER","ROLE_ADMIN"}, user);
		}else{
		us.create(new String[]{"ROLE_USER"}, user);
		}
		return "redirect:/dashboard";
	}	
		
	@RequestMapping("/admin")
	public String roleadmin(@ModelAttribute("user") User user,HttpSession session) {
		System.out.println(user.isAdmin());
		if(user.isAdmin()== true) {
			return "admin";}
		else {
		return "redirect:/dashboard";}
	}
	
	
}