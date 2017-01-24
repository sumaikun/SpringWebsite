package com.avingenieria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avingenieria.models.User;
@Service
public interface UserService {
	public void create(User u);
	public void update(User u);
	public List<User> listUsers();	
	public void destroy(int id);
	public User getUserById(int id);
}
