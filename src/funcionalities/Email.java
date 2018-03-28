package funcionalities;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {


	public void sendEmail(String subject, String mailMessage) {

		final String username = "grupo44es@gmail.com";
		final String password = "projecto2018";

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("grupo44es@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ricnogueira01@gmail.com"));
			message.setSubject(subject);
			message.setText(mailMessage);

			Transport.send(message);
			
		
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}