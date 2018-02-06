package com.example.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.languages.models.Language;
import com.example.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class Languages{
	private final LanguageService languageService;
	
	public Languages(LanguageService languageService){
		this.languageService = languageService;
	}
		
	@RequestMapping("")
	public String languages(Model model){
		model.addAttribute("languages",languageService.all());
		model.addAttribute("language",new Language());
		return "languages.jsp";
	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("language") Language language,BindingResult res,RedirectAttributes attr){
		if(res.hasErrors()){
			attr.addFlashAttribute("errs",res.getAllErrors());
			
			
			return "redirect:/languages";
		}else{
			languageService.create(language);
			return "redirect:/languages";
		}
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") int id,Model model){
		Language language = languageService.getByIndex(id);
		if(language != null){
			model.addAttribute("language",language);
			return "show.jsp";
		}else{
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id,Model model){
		Language language = languageService.getByIndex(id);
		if(language != null){
			model.addAttribute("language",language);
			return "edit.jsp";
		}else{
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int id,@Valid @ModelAttribute("language") Language language,BindingResult res){
		languageService.update(id,language);
		return "redirect:/languages";
	}

	@RequestMapping("/delete/{id}")
	public String destroy(@PathVariable("id") int id){
		languageService.destroy(id);
		return "redirect:/languages";
	}
}
