package jMetal;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.mocell.MOCellBuilder;
import org.uma.jmetal.algorithm.multiobjective.mochc.MOCHCBuilder;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.algorithm.multiobjective.paes.PAESBuilder;
import org.uma.jmetal.algorithm.multiobjective.randomsearch.RandomSearchBuilder;
import org.uma.jmetal.algorithm.multiobjective.smsemoa.SMSEMOABuilder;
import org.uma.jmetal.algorithm.multiobjective.spea2.SPEA2Builder;
import org.uma.jmetal.operator.impl.crossover.HUXCrossover;
import org.uma.jmetal.operator.impl.crossover.SinglePointCrossover;
import org.uma.jmetal.operator.impl.mutation.BitFlipMutation;
import org.uma.jmetal.operator.impl.selection.RandomSelection;
import org.uma.jmetal.operator.impl.selection.RankingAndCrowdingSelection;
import org.uma.jmetal.problem.BinaryProblem;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;
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
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

public class ExperimentsBinaryExternalViaJAR {
	private static final int INDEPENDENT_RUNS = 2;
	private static final int maxEvaluations = 250;
	
	private Problem problem;
	private DefaultListModel algorithmsList;
	private DefaultTableModel fitnessVariables;
	private JProgressBar progressBar;
	private OptimizationProcess5 optimization;
	private int estimatedFinishTime = 0;

	public void startOptimization (Problem problem, DefaultListModel algorithmsList, DefaultTableModel fitnessVariables,OptimizationProcess5 optimization) throws IOException {
		this.problem = problem;
		this.algorithmsList = algorithmsList;
		this.fitnessVariables = fitnessVariables;
		this.optimization = optimization;
		estimatedFinishTime = INDEPENDENT_RUNS * maxEvaluations * algorithmsList.getSize();
		
		String experimentBaseDirectory = "experimentBaseDirectory";

		List<ExperimentProblem<BinarySolution>> problemList = new ArrayList<>();
		problemList.add(new ExperimentProblem<>(new MyProblemBinaryExternalViaJAR(problem, algorithmsList, fitnessVariables,optimization, estimatedFinishTime)));

		List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> algorithmList =
				configureAlgorithmList(problemList,algorithmsList);

		Experiment<BinarySolution, List<BinarySolution>> experiment =
				new ExperimentBuilder<BinarySolution, List<BinarySolution>>("MyProblemBinaryExternalViaJAR")
				.setAlgorithmList(algorithmList)
				.setProblemList(problemList)
				.setExperimentBaseDirectory(experimentBaseDirectory)
				.setOutputParetoFrontFileName("FUN")
				.setOutputParetoSetFileName("VAR")
				.setReferenceFrontDirectory(experimentBaseDirectory+"/referenceFronts")
				.setIndicatorList(Arrays.asList(new PISAHypervolume<BinarySolution>()))
				.setIndependentRuns(INDEPENDENT_RUNS)
				.setNumberOfCores(8)
				.build();

		new ExecuteAlgorithms<>(experiment).run();
		new GenerateReferenceParetoFront(experiment).run();
		new ComputeQualityIndicators<>(experiment).run() ;
		new GenerateLatexTablesWithStatistics(experiment).run() ;
		new GenerateBoxplotsWithR<>(experiment).setRows(1).setColumns(1).run() ;
	}

	static List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> configureAlgorithmList(
			List<ExperimentProblem<BinarySolution>> problemList, DefaultListModel algorithmList) {
		List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> algorithms = new ArrayList<>();

		for (int i = 0; i < problemList.size(); i++) {

			for(int j = 0; j < algorithmList.size(); j++) {
				
				if(algorithmList.get(j).equals("NSGAII")) { 
					Algorithm<List<BinarySolution>> algorithm = new NSGAIIBuilder<>(
							problemList.get(i).getProblem(),
							new SinglePointCrossover(1.0),
							new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0)))
							.setMaxEvaluations(maxEvaluations)
							.setPopulationSize(100)
							.build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm, "NSGAII", problemList.get(i).getTag()));
				}
				if(algorithmList.get(j).equals("SMSEMOA")) {
					Algorithm<List<BinarySolution>> algorithm2 = new SMSEMOABuilder<>(problemList.get(i).getProblem(), new SinglePointCrossover(1.0), new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxEvaluations(maxEvaluations).build();      
					algorithms.add(new ExperimentAlgorithm<>(algorithm2, "SMSEMOA", problemList.get(i).getTag()));
				}
				if(algorithmList.get(j).equals("MOCell")) {
					Algorithm<List<BinarySolution>> algorithm3 = new SMSEMOABuilder<>(problemList.get(i).getProblem(), new SinglePointCrossover(1.0), new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxEvaluations(maxEvaluations).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm3, "MOCell", problemList.get(i).getTag()));
				}
				if(algorithmList.get(j).equals("MOCH")) {
					Algorithm<List<BinarySolution>> algorithm4 = new MOCHCBuilder((BinaryProblem) problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations)
							.setCrossover(new HUXCrossover(1.0)).setNewGenerationSelection(new RankingAndCrowdingSelection<BinarySolution>(100)).setCataclysmicMutation(new BitFlipMutation(0.35)).setParentSelection(new RandomSelection<BinarySolution>()).setEvaluator(new SequentialSolutionListEvaluator<BinarySolution>()).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm4, "MOCH", problemList.get(i).getTag()));
				}
				if(algorithmList.get(j).equals("PAES")) {
					Algorithm<List<BinarySolution>> algorithm5 = new PAESBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).setArchiveSize(100).setBiSections(2).setMutationOperator(new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm5, "PAES", problemList.get(i).getTag()));
				}
				if(algorithmList.get(j).equals("RandomSearch")) {
					Algorithm<List<BinarySolution>> algorithm6 = new RandomSearchBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm6, "RandomSearch", problemList.get(i).getTag()));
				}
				if(algorithmList.get(j).equals("SPEA2")) {
					Algorithm<List<BinarySolution>> algorithm7 = new SPEA2Builder<>(problemList.get(i).getProblem(),new SinglePointCrossover(1.0),new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxIterations(maxEvaluations).build();
					algorithms.add(new ExperimentAlgorithm<>(algorithm7, "SPEA2", problemList.get(i).getTag()));
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
