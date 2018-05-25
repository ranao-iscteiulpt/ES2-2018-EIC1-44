package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import funcionalities.Register;

class RegisterTest {
	
	Register r;
	
	void Register() {
		r = new Register("test", "test@test.com", "test");
	}

	@Test
	void test() {
		Register();
	}

}
