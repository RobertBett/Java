package com.example.loginreg.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.loginreg.models.Role;
import com.example.loginreg.models.User;
import com.example.loginreg.repositories.RoleRepository;
import com.example.loginreg.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bcrypt;
	
	public UserService(UserRepository userRepository ,RoleRepository roleRepository,BCryptPasswordEncoder bcrypt) {
		this.userRepository=userRepository;
		this.roleRepository=roleRepository;
		this.bcrypt = bcrypt;
	}
	public boolean isMatch(String password, String dbpass) {
		if(bcrypt.matches(password, dbpass)) {
			return true;
		}else {
			return false;
		}
	}
	public void login(HttpSession s,long id){s.setAttribute("id",id);}
	
	public void logout(HttpSession s){s.setAttribute("id",null);}
	
	
	public boolean isValid(HttpSession session){
		if(session.getAttribute("id") == null){return false;}
		else{return true;}
	}
	
	public List<User> all(){return (List<User>) userRepository.findAll();}
	
	public User getById(long id) {
		return(User) userRepository.findOne(id);
	}
	
	public User findByEmail(String email) {
		return (User) userRepository.findByEmail(email);
	}
	
	public void create(String[] roles,User user){
		List<Role> userRoles = new ArrayList<>();
		
		for(String role:roles){
			Role getRole = roleRepository.findByName(role);
			if(getRole != null){userRoles.add(getRole);}
		}
				
		user.setPassword(bcrypt.encode(user.getPassword()));
		user.setRoles(userRoles);
		userRepository.save(user);
	}
	
	public void destroy(User user) {
		userRepository.delete(user);
	}
	public void update(User user){userRepository.save(user);}
}
