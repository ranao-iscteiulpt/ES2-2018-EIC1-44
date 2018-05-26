package jMetal;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.mocell.MOCellBuilder;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.algorithm.multiobjective.paes.PAESBuilder;
import org.uma.jmetal.algorithm.multiobjective.randomsearch.RandomSearchBuilder;
import org.uma.jmetal.algorithm.multiobjective.smsemoa.SMSEMOABuilder;
import org.uma.jmetal.operator.impl.crossover.IntegerSBXCrossover;
import org.uma.jmetal.operator.impl.mutation.IntegerPolynomialMutation;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.experiment.Experiment;
import org.uma.jmetal.util.experiment.ExperimentBuilder;
import org.uma.jmetal.util.experiment.component.*;
import org.uma.jmetal.util.experiment.util.ExperimentAlgorithm;
import org.uma.jmetal.util.experiment.util.ExperimentProblem;

import objects.Problem;
import process.OptimizationProcess5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class ExperimentsIntegeExternalViaJAR {
	private static final int INDEPENDENT_RUNS = 2;
	private static final int maxEvaluations = 250;

	private Problem problem;
	private DefaultListModel algorithmsList;
	private DefaultTableModel fitnessVariables;
	private OptimizationProcess5 optimization;
	private int estimatedFinishTime = 0;

	public void startOptimization (Problem problem, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables, OptimizationProcess5 optimization ) throws IOException {
		this.problem = problem;
		this.algorithmsList = algorithmsList;
		this.fitnessVariables = fitnessVariables;
		this.optimization = optimization;
		estimatedFinishTime = INDEPENDENT_RUNS * maxEvaluations * algorithmsList.getSize();
		String experimentBaseDirectory = "experimentBaseDirectory";

		List<ExperimentProblem<IntegerSolution>> problemList = new ArrayList<>();
		problemList.add(new ExperimentProblem<>(new MyProblemIntegerExternalViaJAR(problem, algorithmsList, fitnessVariables, optimization, estimatedFinishTime)));

		List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> algorithmList =
				configureAlgorithmList(problemList,algorithmsList);

		Experiment<IntegerSolution, List<IntegerSolution>> experiment =
				new ExperimentBuilder<IntegerSolution, List<IntegerSolution>>("ExperimentsIntegerExternalViaJAR")
				.setAlgorithmList(algorithmList)
				.setProblemList(problemList)
				.setExperimentBaseDirectory(experimentBaseDirectory)
				.setOutputParetoFrontFileName("FUN")
				.setOutputParetoSetFileName("VAR")
				.setReferenceFrontDirectory(experimentBaseDirectory+"/referenceFronts")
				.setIndicatorList(Arrays.asList(new PISAHypervolume<IntegerSolution>()))
				.setIndependentRuns(INDEPENDENT_RUNS)
				.setNumberOfCores(8)
				.build();

		new ExecuteAlgorithms<>(experiment).run();
		new GenerateReferenceParetoFront(experiment).run();
		new ComputeQualityIndicators<>(experiment).run() ;
		new GenerateLatexTablesWithStatistics(experiment).run() ;
		new GenerateBoxplotsWithR<>(experiment).setRows(1).setColumns(1).run() ;
	}

	static List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> configureAlgorithmList(
			List<ExperimentProblem<IntegerSolution>> problemList, DefaultListModel algorithmList) {
		List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> algorithms = new ArrayList<>();

		for (int i = 0; i < problemList.size(); i++) {
			for(int j = 0; j < algorithmList.size(); j++) {

				if(algorithmList.get(j).equals("NSGAII")) { 
					Algorithm<List<IntegerSolution>> algorithm1 = new NSGAIIBuilder<>(
							problemList.get(i).getProblem(),
							new IntegerSBXCrossover(0.9, 20.0),
							new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0))
							.setMaxEvaluations(maxEvaluations)
							.setPopulationSize(100)
							.build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm1, "NSGAII", problemList.get(i).getTag()));
				}
				
				if(algorithmList.get(j).equals("SMSEMOA")) {
				    Algorithm<List<IntegerSolution>> algorithm2 = new SMSEMOABuilder<>(
				    		problemList.get(i).getProblem(),
				    		new IntegerSBXCrossover(0.9, 20.0),
				    		new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0))
				    		.setMaxEvaluations(maxEvaluations).build();      
					    algorithms.add(new ExperimentAlgorithm<>(algorithm2, "SMSEMOA", problemList.get(i).getTag()));
				}
				
				if(algorithmList.get(j).equals("MOCell")) {
						  Algorithm<List<IntegerSolution>> algorithm3 = new MOCellBuilder<>(
								  problemList.get(i).getProblem(),
								  new IntegerSBXCrossover(0.9, 20.0),
								  new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0))
								  .setMaxEvaluations(maxEvaluations).build();
						  algorithms.add(new ExperimentAlgorithm<>(algorithm3, "MOCell", problemList.get(i).getTag())); 
				}
				
				if(algorithmList.get(j).equals("MOCell")) {
						  Algorithm<List<IntegerSolution>> algorithm4 = new PAESBuilder<>(
								  problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).setArchiveSize(100).setBiSections(2).setMutationOperator(new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0)).build();
						  algorithms.add(new ExperimentAlgorithm<>(algorithm4, "PAES", problemList.get(i).getTag())); 
				}
				
				if(algorithmList.get(j).equals("MOCell")) {
						  Algorithm<List<IntegerSolution>> algorithm5 = new RandomSearchBuilder<>(
								  problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).build();
						  algorithms.add(new ExperimentAlgorithm<>(algorithm5, "RandomSearch", problemList.get(i).getTag()));
				}
				
			}
			/* As simulações com ExternalViaJAR no nome tem as funções de avaliação 
      implementadas em .JAR externos que são invocados no método evaluate() 
      As simulações que executam .jar externos são muito mais demoradas, 
      maxEvaluations e INDEPENDENT_RUNS tem por isso valores mais baixos */      
			/* Deverão ser comentadas ou retiradas de comentário as linhas 
      correspondentes às simulações que se pretendem executar */      

		}
		return algorithms;
	}
	
	public int getEstimatedTime() {
		return estimatedFinishTime;
	}

}
