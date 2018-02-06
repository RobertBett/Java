package com.example.imageupload20.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import com.example.imageupload20.models.Image;
import com.example.imageupload20.services.ImageService;

@Controller
public class HomeController {
	@Autowired
	private ImageService imageService;
	
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("image")Image image, Model model, HttpSession session) {
		List<Image> images = imageService.all();
		
		model.addAttribute("images", images);
		return "image";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam("file") MultipartFile file,HttpSession session,@Valid @ModelAttribute("image")Image image,BindingResult res) {
		if(res.hasErrors()) {
			return "image";
		}else {
			
			try {	byte[] bytes = file.getBytes();
				
				// Creating the directory to store file
				File dir = new File("src/main/resources/static/images");
				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				image.setPicture(file.getOriginalFilename());
				imageService.create(image);
			} catch (Exception e) {
				return "redirect:/dashboard";
			}
			
		} return "redirect:/dashboard";
			
	}
}
