package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.SignUp;
import objects.User;

class SignUpTest {
	
	SignUp su = new SignUp();

	void register() {
		String username = "test";
		String password = "test";
		String email = "test@test.com";
		su.register(username, password, email);
	}
	
	void verifyLogin() {
		String username = "test";
		String password = "test";
		String email = "test@test.com";
		User u = new User(username, password, email);
		su.verifyLogin(u);
	}
	
	@Test
	void test() {
		register();
		verifyLogin();
	}

}
