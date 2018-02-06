package com.example.imageupload20.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.imageupload20.models.Image;
import com.example.imageupload20.repositories.ImageRepository;

@Service
public class ImageService {
	private ImageRepository imageRepository;
	
	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	
	public void create(Image image) {
		imageRepository.save(image);
	}
	
	public ArrayList<Image>all(){
		return (ArrayList<Image>)imageRepository.findAll();
	}
	
	public Image findById(long id) {
		return(Image)imageRepository.findOne(id);
	}
	
	public void update(Image image) {
		imageRepository.save(image);
	}
	
	public void destroy(Image image) {
		imageRepository.delete(image);
	}
	
}
