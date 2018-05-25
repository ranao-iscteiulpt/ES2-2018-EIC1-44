package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import files.XMLOperations;

class XMLOperationsTest {
	
	XMLOperations xo = new XMLOperations();

	void writeXML() {
		String title = "test";
		DefaultTableModel model = new DefaultTableModel(); 
		String description = "test";
		String waitTime = "20 seconds";
		String firstInvalidNumber = "0";
		String secondInvalidNumber = "1";
		xo.writeXML(title, model, description, waitTime, firstInvalidNumber, secondInvalidNumber);
		xo.writeXML(title, model, description, waitTime, firstInvalidNumber);
	}
	
	@Test
	void test() {
		writeXML();
	}

}
