package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import funcionalities.Login;

class LoginTest {
	
	Login l = new Login("test", "test");
	Login l2 = new Login("a", "a");
	Login l3 = new Login("", "");
	Login l4 = new Login("", "test");
	Login l5 = new Login("test", "");
	
	void confirmLogin() {
		l.confirmLogin();
	}

	void confirmLogin2() {
		l2.confirmLogin();
	}
	void confirmLogin3() {
		l3.confirmLogin();
	}
	
	void confirmLogin4() {
		l4.confirmLogin();
	}
	
	void confirmLogin5() {
		l5.confirmLogin();
	}
	
	@Test
	void test() {
		confirmLogin();
		confirmLogin2();
		confirmLogin3();
		confirmLogin4();
		confirmLogin5();
	}

}
