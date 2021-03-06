package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;

import funcionalities.Form;
import jMetal.ExperimentsDoubleExternalViaJAR;
import jMetal.ExperimentsIntegeExternalViaJAR;
import objects.Problem;
import objects.User;
import objects.Variable;
import process.OptimizationProcess5;

class ExperimentsIntegerExternalViaJARTest {

	JPanel jp = new JPanel();
	
	String variableType = new String();
	DefaultListModel<String> algorithmsChosenList = new DefaultListModel<String>();
	User userLoggedIn = new User("test", "test", "test@test.com");
	ArrayList<String> jarList = new ArrayList<String>();
	ArrayList<Variable> a = new ArrayList<Variable>();
	Form form = new Form(jp);
	
	ExperimentsIntegeExternalViaJAR eievj = new ExperimentsIntegeExternalViaJAR();
	
	void startOptimization() {
		Problem problem = new Problem("test", "test", "10 seconds", 0, 0, a);
		DefaultListModel<String> algorithmsList = new DefaultListModel<>();
		algorithmsList.addElement("NSGAII");
		algorithmsList.addElement("SMSEMOA");
		algorithmsList.addElement("MOCell");
		algorithmsList.addElement("MOCell");
		algorithmsList.addElement("MOCell");
		DefaultTableModel fitnessVariables = new DefaultTableModel();
		fitnessVariables.addRow(new Object[] {"Teste","Teste.jar"});
		OptimizationProcess5 optimization = new OptimizationProcess5(form, problem, variableType, algorithmsChosenList, fitnessVariables, userLoggedIn, jarList, variableType);
		try {
			eievj.startOptimization(problem, algorithmsList, fitnessVariables, optimization);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	void test() {
		startOptimization();
	}

}
