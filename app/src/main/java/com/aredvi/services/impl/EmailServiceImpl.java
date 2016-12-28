package com.aredvi.services.impl;

import java.io.StringWriter;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.aredvi.services.interfaces.EmailService;
import com.aredvi.utils.Email;
import com.aredvi.utils.UtilityService;

public class EmailServiceImpl implements EmailService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Autowired
	private SimpleMailMessage messageTemplate;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Override
	public void sendMail(Email email) {
		
		MimeMessage message = mailSender.createMimeMessage();		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject(email.getSubject());
			helper.setFrom(messageTemplate.getFrom());
			
			if(email.getTos() != null && email.getTos().length > 0  ) {
				
				helper.setTo(email.getTos());
				
			} else if(email.getTo() != null && !email.getTo().isEmpty()) {
				
				helper.setTo(email.getTo());
			
			}
			
			if(email.getCcs() != null && email.getCcs().length > 0) {
				
				helper.setCc(email.getCcs());
				
			} else if(null!=email.getCc() && !email.getCc().isEmpty()){
			
				helper.setCc(email.getCc());
			
			}
			
			Template template = velocityEngine.getTemplate("./templates/"+ email.getTemplateName());

			VelocityContext velocityContext = email.getVelocityContext();

			StringWriter stringWriter = new StringWriter();
			template.merge(velocityContext, stringWriter);
			helper.setText(stringWriter.toString(),true);

			this.mailSender.send(message);
		} catch(Exception ex){
			UtilityService.writeLog(LOGGER, ex);
		}
	}
	
}
