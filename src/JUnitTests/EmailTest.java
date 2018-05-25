package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import funcionalities.Email;

class EmailTest {
	
	Email e = new Email();
	
	void sendEmail() {
		String userEmail = "grupo44es@gmail.com";
		String userPassword = "projecto2018";
		String subject = "test";
		String mailMessage = "test";
		e.sendEmail(userEmail, userPassword, subject, mailMessage);
	}

	@Test
	void test() {
		sendEmail();
	}

}
