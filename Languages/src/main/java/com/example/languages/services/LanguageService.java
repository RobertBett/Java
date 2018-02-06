package com.example.languages.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.languages.models.Language;

@Service
public class LanguageService {
	private ArrayList<Language> languages = new ArrayList<>();
	
	public ArrayList<Language> all(){
		return languages;
	}
	
	public Language getByIndex(int ind) {
		if(ind < languages.size()) {
			return languages.get(ind);
		}else {
			return null;
		}
	}
	
	public void create(Language language) {
		languages.add(language);
		
	}
	
	public void update(int id, Language language) {
		if(id<languages.size()) {
			languages.set(id, language);
		}
	}
	
	public void destroy(int id) {
		if(id <languages.size()) {
			languages.remove(id);
		}
	}
	

}
