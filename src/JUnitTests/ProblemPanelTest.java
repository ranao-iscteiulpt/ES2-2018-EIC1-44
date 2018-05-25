package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.ProblemPanel;

class ProblemPanelTest {
	
	ProblemPanel pp = new ProblemPanel();
	
	void initComponents() {
		pp.initComponents();
	}

	@Test
	void test() {
		initComponents();
	}

}
