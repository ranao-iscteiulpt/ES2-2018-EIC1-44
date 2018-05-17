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

import objects.Problem;
import objects.Variable;

/* Implementação de um problema do tipo Double que executa o .jar externo
   Kursawe.jar e pode ser usado como um dos problema de teste indicados 
   no encunciado do trabalho */

@SuppressWarnings("serial")
public class MyProblemDoubleExternalViaJAR extends AbstractDoubleProblem {

	private int contador=0;
	private DefaultTableModel fitnessVariables;
	private JProgressBar progressBar;
	private int estimatedFinishTime;

	public MyProblemDoubleExternalViaJAR(Problem problem, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables, JProgressBar progressBar, int estimatedFinishTime) {
		this(problem.getVariableCounter(),problem,fitnessVariables);
		this.fitnessVariables = fitnessVariables;
		this.progressBar = progressBar;
		this.estimatedFinishTime = estimatedFinishTime;
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
		progressBar.setValue( (contador/estimatedFinishTime)*100 );
		System.out.println(contador);//mostrar progresso da optimizacao
		String solutionString ="";
		String evaluationResultString ="";

		for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			solutionString = solutionString + " " + solution.getVariableValue(i);  
		}

		for (int i =0 ; i < solution.getNumberOfObjectives(); i++) {
			try {			
				String line;
				//Process p = Runtime.getRuntime().exec("java -jar C:\\Users\\Ricardo\\Desktop\\Kursawe.jar" + " " + solutionString);
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
