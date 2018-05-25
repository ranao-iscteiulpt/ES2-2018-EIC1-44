package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import org.junit.jupiter.api.Test;

import files.TEXTOperations;
import objects.Problem;
import objects.User;

class TEXTOperationsTest {
	
	TEXTOperations to = new TEXTOperations();

	void createRegister() {
		String userText = "Teste";
		String passwordText = "teste";
		String emailText = "teste@iscte-iul.pt";
		to.createRegister(userText, passwordText, emailText);
	}
	
	void fillArray() {	
		ArrayList<User> users = new ArrayList<User>();
		to.fillArray(users);
	}
	
	void createGraph() {
		ArrayList<String> jarList = new ArrayList<String>();
		DefaultListModel<String> algorithmsChosenList = new DefaultListModel<String>();
		algorithmsChosenList.addElement("NSGAII");
		Problem problem = new Problem(null, null, null, 0, 0, null);
		to.createGraph(jarList, algorithmsChosenList, problem);
	}
	
	@Test
	void test() {
		createRegister();
		fillArray();
		createGraph();
	}

}
