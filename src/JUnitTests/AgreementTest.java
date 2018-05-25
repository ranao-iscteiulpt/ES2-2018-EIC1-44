package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.Agreement;

class AgreementTest {
	
	Agreement a;
	
	void Frame() {
		a = new Agreement();
		a.init();
	}

	@Test
	void test() {
		Frame();
	}

}
