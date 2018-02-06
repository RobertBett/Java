package com.example.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String home() {
			return "index.jsp";
	}
	
	@RequestMapping("/process")
	public String process(@RequestParam(value="code") String code,RedirectAttributes attr) {
		String b = "money";
		
		if(code.equals(b)) {
			return "redirect:/code";
		}else {
			attr.addFlashAttribute("err", "GUESS AGAIN!!");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
}

