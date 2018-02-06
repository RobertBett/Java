package com.example.languages.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Language {
	@Size(min=2, max=20)
	private String name;
	@Size(min=2, max=20)
	private String creator;
	@NotNull
	private double version;
	
	public Language() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}
	
	
}
