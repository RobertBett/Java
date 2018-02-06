package com.example.auth.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.auth.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByEmail(String email);

}
