package com.avingenieria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avingenieria.models.User;
import com.avingenieria.services.UserService;

public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService uS){
		this.userService = uS;
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public String listUsers(Model model){
		model.addAttribute("user" , new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}
	
	@RequestMapping(value="/users/add", method = RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User u){
		if(u.getId() == 0)
		{
			this.userService.create(u);
		}
		else{
			this.userService.update(u);
		}
		return "redirect:/users.html";
	}
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
	public String removeUser(@PathVariable("id") int id){
		this.userService.destroy(id);
		return "redirect:/users.html";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") int id ,Model model){
		model.addAttribute("user",this.userService.getUserById(id));
		model.addAttribute("listUsers",this.userService.listUsers());
		return "person";
	}
}
