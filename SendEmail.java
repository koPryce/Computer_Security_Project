package com.emailsend;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




public class SendEmail {
	public static void sendMail(String recipient) {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String account = "compsecgroup3@gmail.com";
		String password = "com$3cur1ty";
		
		Session session = Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(account,password);
			}
		});
		
		Message message = prepareMessage(session,account,recipient);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Message prepareMessage(Session session,String account,String recipient) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(account));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
			message.setSubject("QR Code Authentication");
			message.setText("Please see QR code in the attachment below.");
			Multipart content = new MimeMultipart();
			MimeBodyPart part = new MimeBodyPart();
			try {
				String PATH = System.getProperty("user.home")+"\\QRcode";
				part.attachFile(PATH+"\\Quote.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			content.addBodyPart(part);
			message.setContent(content);
			return message;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		return null;

}

}
