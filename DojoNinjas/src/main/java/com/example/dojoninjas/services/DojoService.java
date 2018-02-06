package com.example.dojoninjas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojoninjas.models.Dojo;
import com.example.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
   private DojoRepository dojoRepository;
   @Autowired
   private DojoService(DojoRepository dojoRepository) {
	   this.dojoRepository = dojoRepository;
   }
   
   public void create(Dojo dojo) {
	   dojoRepository.save(dojo);
   }
   
   public void update(Dojo dojo) {
	   dojoRepository.save(dojo);
   }
   
   public void destroy(long id) {
	   dojoRepository.delete(id);
   }
   
   public ArrayList<Dojo> all(){
	   return (ArrayList<Dojo>) dojoRepository.findAll();
   }
   
   public Dojo findByIndex(long id) {
	   return dojoRepository.findOne(id);
   }
   public Dojo getById(long id) {
	   return dojoRepository.findOne(id);
   }
}
