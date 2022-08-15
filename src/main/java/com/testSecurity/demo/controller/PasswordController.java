package com.testSecurity.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testSecurity.demo.dto.ForgotBody;
import com.testSecurity.demo.dto.ResetBody;
import com.testSecurity.demo.service.UserService;

@RestController
@RequestMapping("/password")
public class PasswordController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/forgot")
	public ResponseEntity<Object> forgotPassword(@RequestBody ForgotBody fBody, HttpServletRequest request) {
		userService.sendResetLink(fBody.getEmail(), request.getRemoteHost());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="/reset")
	public ResponseEntity<Object> updatePassword(@RequestBody ResetBody resetBody){
		userService.resetPassword(resetBody.getResetToken(), resetBody.getPassword());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
