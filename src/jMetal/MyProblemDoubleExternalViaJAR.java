package jMetal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import objects.Problem;
import objects.Variable;

/* Implementação de um problema do tipo Double que executa o .jar externo
   Kursawe.jar e pode ser usado como um dos problema de teste indicados 
   no encunciado do trabalho */

@SuppressWarnings("serial")
public class MyProblemDoubleExternalViaJAR extends AbstractDoubleProblem {
	
	private Problem problem;
		
	  public MyProblemDoubleExternalViaJAR(Problem problem, String variableType, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables) {
	    // 10 variables (anti-spam filter rules) by default 
	    this(problem.getVariableCounter());
	    this.problem = problem;
	  }

	  public MyProblemDoubleExternalViaJAR(Integer numberOfVariables) {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2); //tem a haver com as variaveis da optimizacao panel
	    setName("MyProblemDoubleExternalViaJAR");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add( ((Variable) problem.getVariableList().get(i)).getMinValueDouble() );
	      upperLimit.add(((Variable) problem.getVariableList().get(i)).getMaxValueDouble() );
	      System.out.println( "Min " +((Variable) problem.getVariableList().get(i)).getMinValueDouble() );
	      System.out.println( "Max " +((Variable) problem.getVariableList().get(i)).getMinValueDouble() );
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);	    	    
	  }

	  public void evaluate(DoubleSolution solution){
	    String solutionString ="";
	    String evaluationResultString ="";
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	      solutionString = solutionString + " " + solution.getVariableValue(i);  
	    }
	    try {
			String line;
	    	Process p = Runtime.getRuntime().exec("java -jar c:\\Kursawe.jar" + " " + solutionString);
	    	BufferedReader brinput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    	while ((line = brinput.readLine()) != null) 
	    		{evaluationResultString+=line;}
	    	brinput.close();
	        p.waitFor();
	      }
	      catch (Exception err) { err.printStackTrace(); }
   		String[] individualEvaluationCriteria = evaluationResultString.split("\\s+");
	    // It is assumed that all evaluated criteria are returned in the same result string
	    for (int i = 0; i < solution.getNumberOfObjectives(); i++) {
	    	solution.setObjective(i, Double.parseDouble(individualEvaluationCriteria[i]));
	    }	    
	  }
	}
