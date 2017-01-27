package com.avingenieria.dao;

import java.util.List;
import com.avingenieria.models.User;

public interface UserDao {
	
	public void create(User u);
	public void update(User u);
	public List<User> listUsers();	
	public void destroy(int id);
	public User getUserById(int id);
	public User LogginIn(String username);
	
}
