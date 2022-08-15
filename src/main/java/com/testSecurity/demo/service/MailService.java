package com.testSecurity.demo.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.testSecurity.demo.exception.UserException;
import com.testSecurity.demo.interfaces.IMail;

@Service
public class MailService implements IMail{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendMail(String to, String subject, String body) {
		MimeMessage mailMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
		
		// to-do : handle mail error
		try {
			helper.setFrom("someone");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			mailSender.send(mailMessage);
			System.out.println("Mail sent... ");
		}catch(Exception e) {
			throw new UserException("Unexpected error");
		}
	}

}
