package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import gui.EmailPanel;
import gui.Frame;
import objects.User;

class FrameTest {
	
	Frame f = new Frame();
	
	void init() {
		f.init();	
	}

	@Test
	void test() {
		init();
	}

}
