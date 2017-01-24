package com.avingenieria.controller;

import java.util.List;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avingenieria.models.User;
import com.avingenieria.services.UserService;

import com.avingenieria.helpers.*;

@Controller
public class UserController {
	
	private UserService userService;	
	
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService uS){
		this.userService = uS;
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView listUsers(Model model){
		ModelAndView mv = new ModelAndView();
		System.out.println("intento generar la vista de usuarios");
		List<User> listUsers = this.userService.listUsers();
		mv.setViewName("users");
		mv.addObject("listUsers",listUsers);
		mv.addObject("User",new User());
		//model.addAttribute("listUsers", this.userService.listUsers());
		return mv;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u){
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		u.setCreation(currentTime.toString());
		System.out.println(u.toString());
		u.setPassword(password_encrypt.cryptWithMD5(u.getPassword()));		
		
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
	public ModelAndView editUser(@PathVariable("id") int id ,Model model){		
		ModelAndView mv = new ModelAndView();		
		List<User> listUsers = this.userService.listUsers();
		mv.setViewName("users");
		mv.addObject("listUsers",listUsers);
		mv.addObject("User",this.userService.getUserById(id));	
		return mv;
	}
}
