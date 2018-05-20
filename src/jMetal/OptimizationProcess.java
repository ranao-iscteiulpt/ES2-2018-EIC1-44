package jMetal;

import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

import GUITest.OptimizationProcess5;
import objects.Problem;

public class OptimizationProcess {

	private ExperimentsDoubleExternalViaJAR experimentsDouble = new ExperimentsDoubleExternalViaJAR();
	private ExperimentsIntegeExternalViaJAR experimentsInteger =  new ExperimentsIntegeExternalViaJAR();
	private ExperimentsBinaryExternalViaJAR experimentsBinary = new ExperimentsBinaryExternalViaJAR();
	//private ExperimentManualExternalViaJAR experimentManual = new ExperimentManualExternalViaJAR();

	/* O conjunto de algoritmos adequados a cada tipo de problema estão indicados aqui */
	String[] AlgorithmsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithmsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithmsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	
	String[] AlgorithmsForManualProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch","MOCH","SPEA2"};

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

}
