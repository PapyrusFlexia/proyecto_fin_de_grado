package com.proyecto.dao;

import java.util.List;

import com.proyecto.model.Car;
import com.proyecto.model.User;


public interface UserDao {
	
	User findByEmail(String email);
	
	User save(User user);
	
	void deleteByEmail(String email);
	
	List<User> findAllUsers();
	
}
