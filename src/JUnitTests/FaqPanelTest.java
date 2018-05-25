package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.EmailPanel;
import gui.FaqPanel;
import objects.User;

class FaqPanelTest {
	
	FaqPanel fp = new FaqPanel();
	
	void initComponents() {
		fp.initComponents();	
	}

	@Test
	void test() {
		initComponents();
	}

}

