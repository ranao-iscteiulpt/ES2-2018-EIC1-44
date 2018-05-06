package jMetal;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.gde3.GDE3Builder;
import org.uma.jmetal.algorithm.multiobjective.ibea.IBEABuilder;
import org.uma.jmetal.algorithm.multiobjective.mocell.MOCellBuilder;
import org.uma.jmetal.algorithm.multiobjective.moead.MOEADBuilder;
import org.uma.jmetal.algorithm.multiobjective.moead.MOEADBuilder.Variant;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.algorithm.multiobjective.paes.PAESBuilder;
import org.uma.jmetal.algorithm.multiobjective.randomsearch.RandomSearchBuilder;
import org.uma.jmetal.algorithm.multiobjective.smsemoa.SMSEMOABuilder;
import org.uma.jmetal.operator.impl.crossover.SBXCrossover;
import org.uma.jmetal.operator.impl.mutation.PolynomialMutation;
import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.experiment.Experiment;
import org.uma.jmetal.util.experiment.ExperimentBuilder;
import org.uma.jmetal.util.experiment.component.*;
import org.uma.jmetal.util.experiment.util.ExperimentAlgorithm;
import org.uma.jmetal.util.experiment.util.ExperimentProblem;

import objects.Problem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class ExperimentsDoubleExternalViaJAR {
	private static final int INDEPENDENT_RUNS = 2;
	private static final int maxEvaluations = 250;

	private Problem problem;
	private DefaultListModel algorithmsList;
	private DefaultTableModel fitnessVariables;
	

	public void startOptimization (Problem problem, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables) throws IOException {
		this.problem = problem;
		this.algorithmsList = algorithmsList;
		this.fitnessVariables = fitnessVariables;

		String experimentBaseDirectory = "experimentBaseDirectory";
				
		List<ExperimentProblem<DoubleSolution>> problemList = new ArrayList<>();
		problemList.add(new ExperimentProblem<>(new MyProblemDoubleExternalViaJAR(problem, algorithmsList, fitnessVariables)));

		List<ExperimentAlgorithm<DoubleSolution, List<DoubleSolution>>> algorithmList =
				configureAlgorithmList(problemList,algorithmsList);

		Experiment<DoubleSolution, List<DoubleSolution>> experiment =
				new ExperimentBuilder<DoubleSolution, List<DoubleSolution>>("ExperimentsDoubleExternalViaJAR")
				.setAlgorithmList(algorithmList)
				.setProblemList(problemList)
				.setExperimentBaseDirectory(experimentBaseDirectory)
				.setOutputParetoFrontFileName("FUN")
				.setOutputParetoSetFileName("VAR")
				.setReferenceFrontDirectory(experimentBaseDirectory+"/referenceFronts")
				.setIndicatorList(Arrays.asList(new PISAHypervolume<DoubleSolution>()))
				.setIndependentRuns(INDEPENDENT_RUNS)
				.setNumberOfCores(8)
				.build();

		new ExecuteAlgorithms<>(experiment).run();
		new GenerateReferenceParetoSetAndFrontFromDoubleSolutions(experiment).run();
		new ComputeQualityIndicators<>(experiment).run() ;
		new GenerateLatexTablesWithStatistics(experiment).run() ;
		new GenerateBoxplotsWithR<>(experiment).setRows(1).setColumns(1).run() ;
	}

	static List<ExperimentAlgorithm<DoubleSolution, List<DoubleSolution>>> configureAlgorithmList(List<ExperimentProblem<DoubleSolution>> problemList,DefaultListModel algorithmList) {
		List<ExperimentAlgorithm<DoubleSolution, List<DoubleSolution>>> algorithms = new ArrayList<>();
		
		for (int i = 0; i < problemList.size(); i++) {
			
			for(int j = 0; i < algorithmList.size(); j++) {
				
				
				if(algorithmList.get(i).equals("NSGAII")) { 
					Algorithm<List<DoubleSolution>> algorithm1 = new NSGAIIBuilder<>(
							problemList.get(i).getProblem(),
							new SBXCrossover(1.0, 5),
							new PolynomialMutation(1.0 / problemList.get(i).getProblem().getNumberOfVariables(), 10.0))
							.setMaxEvaluations(maxEvaluations)
							.setPopulationSize(100)
							.build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm1, "NSGAII", problemList.get(i).getTag()));    		
				}

				if(algorithmList.get(i).equals("SMSEMOA")) {
					Algorithm<List<DoubleSolution>> algorithm2 = new SMSEMOABuilder<>(
							problemList.get(i).getProblem(),
							new SBXCrossover(1.0, 5), 
							new PolynomialMutation(1.0 / problemList.get(i).getProblem().getNumberOfVariables(), 10.0))
							.setMaxEvaluations(maxEvaluations).build();      
					algorithms.add(new ExperimentAlgorithm<>(algorithm2, "SMSEMOA", problemList.get(i).getTag()));

				}

				if(algorithmList.get(i).equals("GDE3")) {
					Algorithm<List<DoubleSolution>> algorithm3 = new GDE3Builder(
							(DoubleProblem) problemList.get(i).getProblem())
							.setMaxEvaluations(maxEvaluations).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm3, "GDE3", problemList.get(i).getTag()));
				}
				if(algorithmList.get(i).equals("IBEA")) {
						  Algorithm<List<DoubleSolution>> algorithm4 = new IBEABuilder(
								  problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).build();
						  algorithms.add(new ExperimentAlgorithm<>(algorithm4, "IBEA", problemList.get(i).getTag()));
				}
				if(algorithmList.get(i).equals("MOCell")) {
						  Algorithm<List<DoubleSolution>> algorithm5 = new MOCellBuilder<>(
								  problemList.get(i).getProblem(),
								  new SBXCrossover(1.0, 5), 
								  new PolynomialMutation(1.0 / problemList.get(i).getProblem().getNumberOfVariables(), 10.0)).setMaxEvaluations(maxEvaluations).build();
						  algorithms.add(new ExperimentAlgorithm<>(algorithm5, "MOCell", problemList.get(i).getTag()));
				}
				
				if(algorithmList.get(i).equals("MOEAD")) {
						  Algorithm<List<DoubleSolution>> algorithm6 = new MOEADBuilder(problemList.get(i).getProblem(),Variant.MOEAD).setMaxEvaluations(maxEvaluations).build();
						  algorithms.add(new ExperimentAlgorithm<>(algorithm6, "MOEAD", problemList.get(i).getTag()));
				}
				
				if(algorithmList.get(i).equals("PAES")) {
						  Algorithm<List<DoubleSolution>> algorithm7 = new PAESBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).setArchiveSize(100).setBiSections(2).setMutationOperator(new PolynomialMutation(1.0 / problemList.get(i).getProblem().getNumberOfVariables(), 10.0)).build();
						  algorithms.add(new ExperimentAlgorithm<>(algorithm7, "PAES", problemList.get(i).getTag())); 	
				}
				
				if(algorithmList.get(i).equals("RandomSearch")) {
						  Algorithm<List<DoubleSolution>> algorithm8 = new RandomSearchBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).build();
						  algorithms.add(new ExperimentAlgorithm<>(algorithm8, "RandomSearch", problemList.get(i).getTag()));
				}
			}
						
			/*
			
			*/
			/* As simulações com ExternalViaJAR no nome tem as funções de avaliação 
      implementadas em .JAR externos que são invocados no método evaluate() 
      As simulações que executam .jar externos são muito mais demoradas, 
      maxEvaluations e INDEPENDENT_RUNS tem por isso valores mais baixos */      
			/* Deverão ser comentadas ou retiradas de comentário as linhas 
      correspondentes às simulações que se pretendem executar */
		}   
		return algorithms;
	}



}
