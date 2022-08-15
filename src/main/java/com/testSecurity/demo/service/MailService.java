package com.testSecurity.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.testSecurity.demo.interfaces.IMail;

@Service
public class MailService implements IMail{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendMail(String to, String subject, String body) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		// to-do : handle mail error
		mailMessage.setFrom("someone");
		mailMessage.setTo(to);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		
		mailSender.send(mailMessage);
		System.out.println("Mail sent... ");
	}

}
