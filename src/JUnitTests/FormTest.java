package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import funcionalities.Form;

class FormTest {
	
	JPanel jp = new JPanel();
	
	Form f = new Form(jp);
	
	void create() {
		JPanel panelToAdd = new JPanel();
		f.create(panelToAdd);
	}

	@Test
	void test() {
		create();
	}

}
