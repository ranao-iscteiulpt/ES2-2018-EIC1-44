package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import gui.MainPanel;
import objects.User;

class MainPanelTest {
	
	User user = new User("test", "test", "test@test.com");
	JFrame jf = new JFrame();
	
	MainPanel mp = new MainPanel(jf, user);
	
	void mainPanel() {
		mp.mainPanel();
	}

	@Test
	void test() {
		mainPanel();
	}

}
