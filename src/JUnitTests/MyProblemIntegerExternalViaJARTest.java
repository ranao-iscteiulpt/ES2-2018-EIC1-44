package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Test;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.solution.Solution;

import GUITest.OptimizationProcess5;
import funcionalities.Form;
import jMetal.MyProblemIntegerExternalViaJAR;
import objects.Problem;
import objects.User;
import objects.Variable;

class MyProblemIntegerExternalViaJARTest {

	JPanel jp = new JPanel();
	
	String variableType = new String();
	DefaultListModel<String> algorithmsChosenList = new DefaultListModel<String>();
	User userLoggedIn = new User("test", "test", "test@test.com");
	ArrayList<String> jarList = new ArrayList<String>();
	ArrayList<Variable> a = new ArrayList<Variable>();
	Form form = new Form(jp);
	
	MyProblemIntegerExternalViaJAR mpievj;
	
	void MyProblemIntegerExternalViaJAR() {
		Problem problem = new Problem("test", "test", "10 seconds", 0, 0, a);
		DefaultListModel<String> algorithmsList = new DefaultListModel<>();
		algorithmsList.addElement("NSGAII");
		algorithmsList.addElement("SMSEMOA");
		algorithmsList.addElement("MOCell");
		algorithmsList.addElement("MOCH");
		algorithmsList.addElement("PAES");
		algorithmsList.addElement("RandomSearch");
		algorithmsList.addElement("SPEA2");
		DefaultTableModel fitnessVariables = new DefaultTableModel();
		OptimizationProcess5 optimization = new OptimizationProcess5(form, problem, variableType, algorithmsChosenList, fitnessVariables, userLoggedIn, jarList);
		mpievj = new MyProblemIntegerExternalViaJAR(problem, algorithmsList, fitnessVariables, optimization, 20);
	}
	
	void evaluate() {
		IntegerSolution solution = new IntegerSolution() {
			
			@Override
			public void setVariableValue(int index, Integer value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setObjective(int index, double value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setAttribute(Object id, Object value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String getVariableValueString(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getVariableValue(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public double getObjective(int index) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getNumberOfVariables() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getNumberOfObjectives() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getAttribute(Object id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Solution<Integer> copy() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getUpperBound(int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getLowerBound(int index) {
				// TODO Auto-generated method stub
				return null;
			}
		}; 
		
		mpievj.evaluate(solution);
	}
	
	@Test
	void test() {
		MyProblemIntegerExternalViaJAR();
		evaluate();
	}

}
