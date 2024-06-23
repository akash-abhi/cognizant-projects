package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Email;
import com.cognizant.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	 private EmailService senderService;
	
	@GetMapping("/sendemail")
	public String sendemail(@RequestBody Email email) {
		System.out.println(email.getBody());
		System.out.println(email.getTo());
		System.out.println(email.getSubject());
		senderService.sendEmail(email.getTo(), email.getSubject(), email.getBody());
		return "Email sent successfully";
	}
	@GetMapping("/hello")
	public String Hello() {
		return "hello";
	}
}