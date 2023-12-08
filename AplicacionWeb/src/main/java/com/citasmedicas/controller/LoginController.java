package com.citasmedicas.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	 @GetMapping("/usuario_facebook")
	    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		 	System.out.println(principal.toString());  
		 	return Collections.singletonMap("nombreFacebook", principal.getAttribute("name"));
	 	}
	 
	 @GetMapping("/mensajito")
	 public String message(Model model) {
	     String msg = "This is a custom message" ;
	     //model.addAttribute("msg", msg);
	     return "message";
	 }
	 


}
