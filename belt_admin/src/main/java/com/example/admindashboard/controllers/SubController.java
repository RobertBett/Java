package com.example.admindashboard.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.admindashboard.models.Role;
import com.example.admindashboard.models.Sub;
import com.example.admindashboard.models.User;
import com.example.admindashboard.services.RoleService;
import com.example.admindashboard.services.SubService;
import com.example.admindashboard.services.UserService;

@Controller
@RequestMapping("/subs")
public class SubController {
	private SubService subService;
	private UserService userService;
	private RoleService roleService;
	
	public SubController( SubService subService, UserService userService,RoleService roleService) {
		this.subService = subService;
		this.userService =userService;
		this.roleService = roleService;
	}
	
	@RequestMapping("")
	public String sub(@Valid @ModelAttribute("sub") Sub sub) {
		return "subShow";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("sub") Sub sub, BindingResult res, HttpSession session, Model model) {
		if(res.hasErrors()) {
			return "redirect:/subs";
		}subService.create(sub);
		long user_id =(long)session.getAttribute("id");
		Role u=(Role)roleService.getById(user_id);
		sub.setRole(u);
		subService.create(sub);
		return "redirect:/admin";
	}
	
	@PostMapping("/{id}/join")
	public String join(@PathVariable("id") long sub_id, HttpSession session) {
		Sub s=subService.findById(sub_id);
		long user_id = (long)session.getAttribute("id");
		User u =(User) userService.getById(user_id);
		List<User> users =s.getUsers();
		users.add(u);
		s.setUsers(users);
		
		subService.update(s);
		return "redirect:/subs";
	}
	@RequestMapping("/show")
	public String show(@ModelAttribute("sub") Sub sub,Model model) {
		model.addAttribute("subs", subService.all());
		return "dashboard";
	}
	
	
	

}
