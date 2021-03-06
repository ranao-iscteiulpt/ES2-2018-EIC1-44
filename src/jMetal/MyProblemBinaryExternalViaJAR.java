package jMetal;

import org.uma.jmetal.problem.impl.AbstractBinaryProblem;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.solution.impl.DefaultBinarySolution;
import org.uma.jmetal.util.JMetalException;

import objects.Problem;
import process.OptimizationProcess5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/* Implementação de um problema do tipo Binary que executa o .jar externo
   OneZeroMax.jar e pode ser usado como um dos problema de teste indicados 
   no encunciado do trabalho */

@SuppressWarnings("serial")
public class MyProblemBinaryExternalViaJAR extends AbstractBinaryProblem {
	
	private DefaultTableModel fitnessVariables;
	private OptimizationProcess5 optimization;
	private int estimatedFinishTime;
	private double contador;
	private double percent;
	private int bits ;

	public MyProblemBinaryExternalViaJAR(Problem problem, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables, OptimizationProcess5 optimization, int estimatedFinishTime) throws JMetalException { 
		this(problem.getVariableCounter(),problem,fitnessVariables);
		this.estimatedFinishTime = estimatedFinishTime;
		this.fitnessVariables = fitnessVariables;
		this.optimization = optimization;
		optimization.updateProgressBar();
	}

	public MyProblemBinaryExternalViaJAR(Integer numberOfBits, Problem problem, DefaultTableModel fitnessVariables) throws JMetalException {
		setNumberOfVariables(1); //?
		setNumberOfObjectives(fitnessVariables.getRowCount());
		setName("MyProblemBinaryExternalViaJAR");
		bits = numberOfBits ;

	}

	@Override
	protected int getBitsPerVariable(int index) {
		if (index != 0) {
			throw new JMetalException("Problem MyBinaryProblem has only a variable. Index = " + index) ;
		}
		return bits ;
	}

	@Override
	public BinarySolution createSolution() {
		return new DefaultBinarySolution(this) ;
	}

	@Override
	public void evaluate(BinarySolution solution){
		contador++;
		percent = ((contador)/estimatedFinishTime)*100;
		optimization.setProgressPercent((int)percent);
		String solutionString ="";
		String evaluationResultString ="";
		BitSet bitset = solution.getVariableValue(0) ;
		solutionString = bitset.toString();
		for (int i =0 ; i < solution.getNumberOfObjectives(); i++) {
			try {
				String line;
				//Process p = Runtime.getRuntime().exec("java -jar C:\\Users\\Ricardo\\Desktop\\OneZeroMax.jar" + " " + solutionString);
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
