package com.avingenieria.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avingenieria.dao.RoleDao;
import com.avingenieria.models.Role;


@Service
public class RoleServiceImp implements RoleService {
	
	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao){
		this.roleDao = roleDao;
	}
	
	@Transactional
	@Override
	public List<Role> listroles() {
		return this.roleDao.listroles();
	}

}
