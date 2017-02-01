package com.avingenieria.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avingenieria.models.Role;

@Service
public interface RoleService {

	List<Role> listroles();

}
