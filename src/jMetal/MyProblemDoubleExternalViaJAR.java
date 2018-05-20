package jMetal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType;
import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import GUITest.OptimizationProcess5;
import objects.Problem;
import objects.Variable;

/* Implementação de um problema do tipo Double que executa o .jar externo
   Kursawe.jar e pode ser usado como um dos problema de teste indicados 
   no encunciado do trabalho */

@SuppressWarnings("serial")
public class MyProblemDoubleExternalViaJAR extends AbstractDoubleProblem {

	private DefaultTableModel fitnessVariables;
	private OptimizationProcess5 optimization;
	private int estimatedFinishTime;
	private double contador;
	private double percent;

	public MyProblemDoubleExternalViaJAR(Problem problem, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables, OptimizationProcess5 optimization, int estimatedFinishTime) {
		this(problem.getVariableCounter(),problem,fitnessVariables);
		this.estimatedFinishTime = estimatedFinishTime;
		this.fitnessVariables = fitnessVariables;
		this.optimization = optimization;
		optimization.updateProgressBar();
		
	}

	public MyProblemDoubleExternalViaJAR(Integer numberOfVariables,Problem problem,DefaultTableModel fitnessVariables) {
		
		setNumberOfVariables(numberOfVariables);
		//System.out.println(fitnessVariables.getRowCount());
		setNumberOfObjectives(fitnessVariables.getRowCount()); //tem a haver com as variaveis da optimizacao panel
		setName("MyProblemDoubleExternalViaJAR");

		List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
		List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

		for (int i = 0; i < getNumberOfVariables(); i++) {
			lowerLimit.add( ((Variable) problem.getVariableList().get(i)).getMinValueDouble() );
			upperLimit.add(((Variable) problem.getVariableList().get(i)).getMaxValueDouble() );
		}

		setLowerLimit(lowerLimit);
		setUpperLimit(upperLimit);	    	    
	}

	public void evaluate(DoubleSolution solution){
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
			solution.setObjective(i, Double.parseDouble(individualEvaluationCriteria[i]));
		}	
	}
	
	
}
