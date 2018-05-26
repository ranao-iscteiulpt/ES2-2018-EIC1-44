package jMetal;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.JMetalException;

import objects.Problem;
import objects.Variable;
import process.OptimizationProcess5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

/* Implementação de um problema do tipo Integer que executa o .jar externo
   NMMin.jar e pode ser usado como um dos problema de teste indicados 
   no encunciado do trabalho */

@SuppressWarnings("serial")
public class MyProblemIntegerExternalViaJAR extends AbstractIntegerProblem {

	private DefaultTableModel fitnessVariables;
	private OptimizationProcess5 optimization;
	private int estimatedFinishTime;
	private double contador;
	private double percent;

	public MyProblemIntegerExternalViaJAR(Problem problem, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables, OptimizationProcess5 optimization, int estimatedFinishTime) throws JMetalException {
		this(problem.getVariableCounter(),problem,fitnessVariables);
		this.estimatedFinishTime = estimatedFinishTime;
		this.fitnessVariables = fitnessVariables;
		this.optimization = optimization;
		optimization.updateProgressBar();
	}

	public MyProblemIntegerExternalViaJAR(Integer numberOfVariables, Problem problem, DefaultTableModel fitnessVariables) throws JMetalException {
		System.out.println("NUMBEROFVARIABLES " + fitnessVariables.getRowCount());
		setNumberOfVariables(numberOfVariables);
		setNumberOfObjectives(fitnessVariables.getRowCount());
		setName("MyProblemIntegerExternalViaJAR");

		List<Integer> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
		List<Integer> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

		for (int i = 0; i < getNumberOfVariables(); i++) {
			lowerLimit.add( ((Variable) problem.getVariableList().get(i)).getMinValue() );
			upperLimit.add( ((Variable) problem.getVariableList().get(i)).getMaxValue() );
		}

		setLowerLimit(lowerLimit);
		setUpperLimit(upperLimit);

	}

	public void evaluate(IntegerSolution solution){
		contador++;
		percent = ((contador)/estimatedFinishTime)*100;
		optimization.setProgressPercent((int)percent);
		String solutionString ="";
		String evaluationResultString ="";
		for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			solutionString = solutionString + " " + solution.getVariableValue(i);  
		}
		
		for (int i =0 ; i < solution.getNumberOfObjectives(); i++) {
			try {
				String line;
				//Process p = Runtime.getRuntime().exec("java -jar c:\\NMMin.jar" + " " + solutionString);
				Process p = Runtime.getRuntime().exec("java -jar " + fitnessVariables.getValueAt(i, 1) + " " + solutionString);
				BufferedReader brinput = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = brinput.readLine()) != null) 
				{evaluationResultString+=line+" ";}
				brinput.close();
				p.waitFor();
			}
			catch (Exception err) { err.printStackTrace(); }
		}

		String[] individualEvaluationCriteria = evaluationResultString.split("\\s+");
		// It is assumed that all evaluated criteria are returned in the same result string
		for (int i = 0; i < solution.getNumberOfObjectives(); i++) {
			solution.setObjective(i, Integer.parseInt(individualEvaluationCriteria[i]));    
		}	    
	}	  
}
