package com.api.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.demo.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	

}
