package jMetal;

import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

import objects.Problem;
import process.OptimizationProcess5;

public class OptimizationProcess {

	private ExperimentsDoubleExternalViaJAR experimentsDouble = new ExperimentsDoubleExternalViaJAR();
	private ExperimentsIntegeExternalViaJAR experimentsInteger =  new ExperimentsIntegeExternalViaJAR();
	private ExperimentsBinaryExternalViaJAR experimentsBinary = new ExperimentsBinaryExternalViaJAR();
	//private ExperimentManualExternalViaJAR experimentManual = new ExperimentManualExternalViaJAR();

	/* O conjunto de algoritmos adequados a cada tipo de problema est�o indicados aqui */
	String[] AlgorithmsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithmsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithmsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	
	String[] AlgorithmsForManualProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch","MOCH","SPEA2"};

	/**
	 * Method to initialize the optimization process based on type of experiments (double, integer or binary)
	 * @param problem problem to optimize
	 * @param variableType variable type (double, integer or binary)
	 * @param algorithmsList list of selected algorithms
	 * @param fitnessVariables selected JAR Files
	 * @param optimization selected optimization
	 */
	
	public void init(Problem problem, String variableType, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables, OptimizationProcess5 optimization ) {
		try {
			if(variableType.equals("double"))
				experimentsDouble.startOptimization(problem, algorithmsList, fitnessVariables, optimization);

			if(variableType.equals("integer"))
				experimentsInteger.startOptimization(problem, algorithmsList, fitnessVariables, optimization);

			if(variableType.equals("binary"))
				experimentsBinary.startOptimization(problem, algorithmsList, fitnessVariables, optimization);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	public String[] getAlgorithmsDouble() {
		return AlgorithmsForDoubleProblemType;
	}

	public String[] getAlgorithmsInteger() {
		return AlgorithmsForIntegerProblemType;
	}

	public String[] getAlgorithmsBinary() {
		return AlgorithmsForBinaryProblemType;
	}
	
	public String[] getAlgorithmsManual() {
		return AlgorithmsForManualProblemType;
	}
	
	public ExperimentsDoubleExternalViaJAR getExperimentsDouble() {
		return experimentsDouble;
	}
	
	public ExperimentsIntegeExternalViaJAR getExperimentsInteger() {
		return experimentsInteger;
	}
	
	public ExperimentsBinaryExternalViaJAR getExperimentsBinary() {
		return experimentsBinary;
	}
}
