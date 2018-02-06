package com.example.admindashboard.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.admindashboard.models.Sub;
import com.example.admindashboard.repositories.SubRepository;

@Service
public class SubService {
	private SubRepository subRepository;
	
	public SubService(SubRepository subRepository) {
		this.subRepository =subRepository;
	}
	
	public void create(Sub sub) {
		subRepository.save(sub);
	}
	public ArrayList<Sub>all(){
		return(ArrayList<Sub>)subRepository.findAll();
	}
	public Sub findById(long id) {
		return(Sub)subRepository.findOne(id);
	}
	
	public void update(Sub sub) {
		create(sub);
	}
	public void destroy(Sub sub) {
		subRepository.delete(sub);
	}
	
	public ArrayList<Sub>findByName(String name){
		return(ArrayList<Sub>)subRepository.findByName(name);
	}

}
