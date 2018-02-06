package com.example.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dojoninjas.models.Dojo;
import com.example.dojoninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	private DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") long id, Model model) {
		model.addAttribute("dojo", dojoService.findByIndex(id));
		return "show_dojo";
	}
	
	@RequestMapping("/new")
	public String _new(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "new_dojo";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult res, RedirectAttributes re, Model model) {
		if(res.hasErrors()) {
			re.addFlashAttribute("errs", res.getAllErrors());
			return "redirect:/dojos/new";
		}else {
			dojoService.create(dojo);
			return "redirect:/";
		}
	}
}
