package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import gui.RegisterPanel;

class RegisterPanelTest {
	
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	RegisterPanel rp = new RegisterPanel(jf, jp);
	
	void initComponents() {
		rp.initComponents();
	}

	@Test
	void test() {
		initComponents();
	}

}
