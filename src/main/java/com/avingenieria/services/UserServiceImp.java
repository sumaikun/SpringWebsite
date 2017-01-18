package com.avingenieria.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avingenieria.dao.UserDao;
import com.avingenieria.models.User;


@Service
public class UserServiceImp implements UserService{

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Transactional
	@Override
	public void create(User u) {
		this.userDao.create(u);		
	}
	@Transactional
	@Override
	public void update(User u) {
		this.userDao.update(u);		
	}
	@Transactional
	@Override
	public List<User> listUsers() {
		return this.userDao.listUsers();
	}
	@Transactional
	@Override
	public void destroy(int id) {
		this.userDao.destroy(id);		
	}
	@Transactional
	@Override
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}

}
