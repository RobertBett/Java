package com.example.loginreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.loginreg.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long>{
	public Role findByName(String name);
	public List<Role> findAll();
}