package com.testSecurity.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testSecurity.demo.dto.ForgotBody;
import com.testSecurity.demo.service.UserService;

@RestController
@RequestMapping("/password")
public class PasswordController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/forgot")
	public void forgotPassword(@RequestBody ForgotBody fBody) {
		
	}
}
