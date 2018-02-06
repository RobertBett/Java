package com.example.loginreg.models;





import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class User{
	@Id
	@GeneratedValue
	private long id;

	@Size(min=8)
	private String email;
	
	@Size(min=1,max=255,message ="Name Cannot Be Blank")
	private String firstName;

	@Size(min=1,max=255)
	private String lastName;

	@Size(min=8,max=255)
	private String password;

	@Transient
	@Size(min=8,max=255)	
	private String confirm;

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="users_roles",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="role_id")
	)
	private List<Role> roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setConfirm(String confirm){
		this.confirm=confirm;
	}	

	public String getEmail(){return email;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public String getPassword(){return password;}
	public String getConfirm(){return confirm;}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public boolean isAdmin(){
		for(Role role:this.roles){			
			if(role.getName().equals("ROLE_ADMIN")){return true;}
		}
		return false;
	}

	public User(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}