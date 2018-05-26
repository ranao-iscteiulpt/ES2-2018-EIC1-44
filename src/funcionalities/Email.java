package funcionalities;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

	/**
	 * Method to send an email to the user
	 * @param userEmail user email
	 * @param userPassword user password
	 * @param subject message subject
	 * @param mailMessage message sent
	 */
	
	public void sendEmail(String userEmail, String userPassword, String subject, String mailMessage) {

		//final String username = "grupo44es@gmail.com";
		//final String password = "projecto2018";
		
		final String username = userEmail;
		final String password = userPassword;

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
			message.setFrom(new InternetAddress(userEmail));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ricnogueira01@gmail.com"));
			message.setSubject(subject);
			message.setText(mailMessage);

			Transport.send(message);
			
		
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
<<<<<<< HEAD
	/**
	 * Method to inform the user about the optimization progress in the different stages (25%, 50%, 75% and 100%)
	 * @param mailMessage message sent
	 */
=======
	public void sendEmailWithAttachment(String userEmail, String userPassword, String subject, String mailMessage, String filePath) {
		final String username = userEmail;
		final String password = userPassword;

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
			message.setFrom(new InternetAddress(userEmail));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ricnogueira01@gmail.com"));
			message.setSubject(subject);
			message.setText(mailMessage);
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        messageBodyPart = new MimeBodyPart();
	        String file = filePath;
	        String fileName = "XML File";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);
			Transport.send(message);
		
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
>>>>>>> d8dda54bf9fd780cd11d9ed002a6716166579726
	
	public void updateUser( String mailMessage) {
		final String userEmail = "grupo44es@gmail.com";
				final String userPassword = "projecto2018";
				
				final String username = userEmail;
				final String password = userPassword;

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
					message.setFrom(new InternetAddress(userEmail));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse("ricnogueira01@gmail.com"));
					message.setSubject("Optimization Progress");
					message.setText(mailMessage);

					Transport.send(message);
					
				
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
	}
}