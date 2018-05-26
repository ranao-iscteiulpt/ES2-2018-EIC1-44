package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import funcionalities.Form;
import objects.User;

class OptimizationProcess1Test {
	
	JPanel jp = new JPanel();
	
	Form form = new Form(jp);
	User userLoggedIn = new User("test", "test", "test@test.com");
	
	process.OptimizationProcess1 op1;
	
	void OptimizationProcess1() {
		
		op1 = new process.OptimizationProcess1(form, userLoggedIn);
	}

	@Test
	void test() {
		OptimizationProcess1();
	}

}
