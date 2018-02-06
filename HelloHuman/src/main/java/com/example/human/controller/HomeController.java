package com.example.human.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController{
	@RequestMapping("")
	public String index(@RequestParam(value="first",defaultValue="Human") String first,@RequestParam(value="last",defaultValue="") String last,Model model){
		model.addAttribute("first",first);
		model.addAttribute("last",last);
		return "index.jsp";
	}
}

