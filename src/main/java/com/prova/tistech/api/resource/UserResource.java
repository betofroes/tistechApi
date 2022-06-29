package com.prova.tistech.api.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prova.tistech.api.dto.User;
import com.prova.tistech.api.security.TokenAuthenticationService;

@RestController
public class UserResource {

	@PostMapping("user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = TokenAuthenticationService.getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}
}
