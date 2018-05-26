package objects;

import java.util.ArrayList;

public class Problem {

	private ArrayList<Variable> variableList;
	private String name;
	private String description;
	private String waitTime;
	private int invalidValue;
	private int variableCounter;
	private int firstInvalidValue;
	private int secondInvalidValue;
	
	/**
	 * Method to create a problem with one invalid value
	 * @param name problem name
	 * @param description problem description
	 * @param waitTime problem waiting time
	 * @param invalidValue problem invalid value
	 * @param variableCounter variable pointer
	 * @param variableList list with all problem variables
	 */
	
	public Problem(String name, String description, String waitTime, int invalidValue, int variableCounter,ArrayList<Variable> variableList) {
		this.name = name;
		this.description = description;
		this.waitTime = waitTime;
		this.invalidValue = invalidValue;
		this.variableCounter = variableCounter;
		this.variableList = variableList;
	}
	
	/**
	 * Method to create a problem
	 * @param name problem's name
	 * @param description text with problem's description
	 * @param waitTime problem's waiting time
	 * @param firstInvalidNumber first number that limits an interval of values that should not be considered
	 * @param secondInvalidNumber second number that limits an interval of values that should not be considered
	 * @param variableCounter variable pointer
	 * @param variableList list with all problem variables
	 */
	
	public Problem(String name, String description, String waitTime, int firstInvalidValue,int secondInvalidValue, int variableCounter,ArrayList<Variable> variableList) {
		this.name = name;
		this.description = description;
		this.waitTime = waitTime;
		this.variableCounter = variableCounter;
		this.variableList = variableList;
		this.firstInvalidValue = firstInvalidValue;
		this.secondInvalidValue = secondInvalidValue;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getWaitTime() {
		return waitTime;
	}

	public int getInvalidValue() {
		return invalidValue;
	}

	public int getVariableCounter() {
		return variableCounter;
	}
	
	public ArrayList getVariableList() {
		return variableList;
	}
	
	public int getFirstInvalidValue() {
		return firstInvalidValue;
	}
	
	public int getSecondInvalidValue() {
		return secondInvalidValue;
	}
	
	@Override
	public String toString() {
		return "Problem Name: "+name+", Description: "+description+", waiTime: " +waitTime+", invalidValue: "+invalidValue+", Variables" + variableList;
	}

}
