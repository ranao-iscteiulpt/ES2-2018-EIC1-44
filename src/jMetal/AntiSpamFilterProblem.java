package jMetal;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import objects.Problem;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {
	
	private Problem problem;

	  public AntiSpamFilterProblem(Problem problem) {
	    // 10 variables (anti-spam filter rules) by default
	    this(problem.getVariableCounter());
	    this.problem = problem; 
	  }

	  public AntiSpamFilterProblem(Integer numberOfVariables) {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2); //tem a haver com variaveis criadas na optimizacao
	    setName(problem.getName()); //"AntiSpamFilterProblem"

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(-5.0);
	      upperLimit.add( 5.0 );
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }

	  public void evaluate(DoubleSolution solution){ //aqui executar os jars
	    double aux, xi, xj;
	    double[] fx = new double[getNumberOfObjectives()];
	    double[] x = new double[getNumberOfVariables()];
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	      x[i] = solution.getVariableValue(i) ;
	    }

	    fx[0] = 0.0;
	    for (int var = 0; var < solution.getNumberOfVariables() - 1; var++) {
		  fx[0] += Math.abs(x[0]); // Example for testing
	    }
	    
	    fx[1] = 0.0;
	    for (int var = 0; var < solution.getNumberOfVariables(); var++) {
	    	fx[1] += Math.abs(x[1]); // Example for testing
	    }

	    solution.setObjective(0, fx[0]);
	    solution.setObjective(1, fx[1]);
	  }
	}
