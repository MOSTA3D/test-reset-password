package com.testSecurity.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testSecurity.demo.entity.UserEntity;
import com.testSecurity.demo.exception.UserException;
import com.testSecurity.demo.repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MailService mailService;
	
	public void sendResetLink(String email, String host) {
		String token = RandomString.make(45);
		String resetLink = host + "/reset_password?token=" + token;
		
			
		String mailSubject = "Reset password request";
		String mailBody = "<h2>Reset Password Request</h2>" + 
		 		  		  "<p>Please visit <a href=\"http://" + resetLink + "\"> <bold>this link</bold> </a> to reset your password </p>";

		
		Optional<UserEntity> userReturnedOptional = userRepo.findByEmail(email);
		if(userReturnedOptional.isEmpty()) {
			throw new UserException("No user found with email " + email);
		}
		
		UserEntity userReturned = userReturnedOptional.get();
		userReturned.setResetToken(token);
		userRepo.save(userReturned);
		
		mailService.sendMail(email, mailSubject, mailBody);
	}
	
	public void resetPassword(String newPassword, String resetToken) {
		Optional<UserEntity> userReturnedOptional = userRepo.findByResetToken(resetToken);

		if(userReturnedOptional.isEmpty()) {
			throw new UserException("You are not authorized to make this operation");
		}
		
		System.out.println("after throwing ");
		
		UserEntity userReturned = userReturnedOptional.get();
		
		// to-do : using bcrypt to hash the password
		String hashedPassword = newPassword;
		
		userReturned.setPassword(hashedPassword);
		
		userRepo.save(userReturned);
	}
}
