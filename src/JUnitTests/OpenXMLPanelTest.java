package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import gui.OpenXMLPanel;

class OpenXMLPanelTest {

	OpenXMLPanel oxpt;
	
	void OpenXMLPanel() {
		File f = new File("Test");
		oxpt = new OpenXMLPanel(f);
	}
	
	@Test
	void test() {
		OpenXMLPanel();
	}

}
