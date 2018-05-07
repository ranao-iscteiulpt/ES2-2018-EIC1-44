package jMetal;

import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import objects.Problem;

public class OptimizationProcess {

	private ExperimentsDoubleExternalViaJAR experimentsDouble = new ExperimentsDoubleExternalViaJAR();
	private ExperimentsIntegeExternalViaJAR experimentsInteger =  new ExperimentsIntegeExternalViaJAR();
	private ExperimentsBinaryExternalViaJAR experimentsBinary = new ExperimentsBinaryExternalViaJAR();

	/* O conjunto de algoritmos adequados a cada tipo de problema estão indicados aqui */
	String[] AlgorithmsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithmsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithmsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	

	public void init(Problem problem, String variableType, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables) {
		try {
			/* Deverão ser comentadas ou retiradas de comentário as linhas 
   correspondentes às simulações que se pretendem executar */
			//			ExperimentsDouble.main(null);
			//			ExperimentsInteger.main(null);
			//			ExperimentsBinary.main(null);

			/* As simulações com ExternalViaJAR no nome tem as funções de avaliação 
   implementadas em .JAR externos que são invocados no método evaluate() 
   As simulações que executam .jar externos são muito mais demoradas, 
   maxEvaluations e INDEPENDENT_RUNS tem por isso valores mais baixos */

			if(variableType.equals("double"))
				experimentsDouble.startOptimization(problem, algorithmsList, fitnessVariables);

			if(variableType.equals("integer"))
				experimentsInteger.startOptimization(problem, algorithmsList, fitnessVariables);

			if(variableType.equals("binary"))
				experimentsBinary.startOptimization(problem, algorithmsList, fitnessVariables);	

		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("acabou");
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
}
