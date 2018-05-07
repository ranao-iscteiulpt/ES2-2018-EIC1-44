package jMetal;

import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import objects.Problem;

public class OptimizationProcess {

	private ExperimentsDoubleExternalViaJAR experimentsDouble = new ExperimentsDoubleExternalViaJAR();
	private ExperimentsIntegeExternalViaJAR experimentsInteger =  new ExperimentsIntegeExternalViaJAR();
	private ExperimentsBinaryExternalViaJAR experimentsBinary = new ExperimentsBinaryExternalViaJAR();

	/* O conjunto de algoritmos adequados a cada tipo de problema est�o indicados aqui */
	String[] AlgorithmsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithmsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithmsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	

	public void init(Problem problem, String variableType, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables) {
		try {
			/* Dever�o ser comentadas ou retiradas de coment�rio as linhas 
   correspondentes �s simula��es que se pretendem executar */
			//			ExperimentsDouble.main(null);
			//			ExperimentsInteger.main(null);
			//			ExperimentsBinary.main(null);

			/* As simula��es com ExternalViaJAR no nome tem as fun��es de avalia��o 
   implementadas em .JAR externos que s�o invocados no m�todo evaluate() 
   As simula��es que executam .jar externos s�o muito mais demoradas, 
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
