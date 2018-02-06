package com.example.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.loginreg.models.User;
import com.example.loginreg.services.RoleService;
import com.example.loginreg.services.UserService;
import com.example.loginreg.validator.UserValidator;

@Controller
public class UserController{
	private UserService us;
	private UserValidator uv;
	private RoleService roleService;

	public UserController(UserService us, UserValidator uv){
		this.us=us;
		this.uv=uv;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession s){
		if( s.getAttribute("id") != null ){
			return "dashboard";
		}else{
			return "redirect:/";
		}
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
		return "redirect:/";
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user,HttpSession s){
		s.setAttribute("id",null);
		return "register";
	}

	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("user") User user,BindingResult res,HttpSession session){
		uv.validate(user, res);
		if(res.hasErrors()){
			return "register";

		}else if(roleService.findByName("ROLE_ADMIN").getUsers().size() < 1){ 
			us.create(new String[]{"ROLE_USER","ROLE_ADMIN"}, user);
			session.setAttribute( "id",user.getId() );
			session.setAttribute( "currentUser",user);
			return "redirect:/";
			
		}us.create(new String[]{"ROLE_USER"}, user);
		session.setAttribute( "id",user.getId() );
		session.setAttribute( "currentUser",user);
		return "redirect:/";

	
		
	}
	
}