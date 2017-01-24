package com.avingenieria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller  
@SessionAttributes 
public class LoginController {
	
	  @RequestMapping("/login")  
	    public ModelAndView showContacts() {  
	        return new ModelAndView("login");  
	    }  
}
