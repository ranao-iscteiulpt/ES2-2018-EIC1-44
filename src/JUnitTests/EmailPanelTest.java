package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.EmailPanel;
import objects.User;

class EmailPanelTest {
	
	User user = new User("test", "test", "test@test.com");
	
	EmailPanel ep = new EmailPanel(user);
	
	void initComponents() {
		ep.initComponents();	
	}

	@Test
	void test() {
		initComponents();
	}

}
