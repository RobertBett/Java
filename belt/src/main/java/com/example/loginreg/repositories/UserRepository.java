package com.example.loginreg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.loginreg.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
		public User findByEmail(String email);
}
