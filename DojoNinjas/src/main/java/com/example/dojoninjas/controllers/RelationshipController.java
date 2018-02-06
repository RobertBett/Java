package com.example.dojoninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dojoninjas.services.DojoService;

@Controller
@RequestMapping("/")
public class RelationshipController {
	@Autowired
	private  DojoService dojoService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("dojos", dojoService.all());
		return"dashboard";
	}

}
