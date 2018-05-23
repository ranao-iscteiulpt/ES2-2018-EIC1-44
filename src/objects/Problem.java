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
	
	public Problem(String name, String description, String waitTime, int invalidValue, int variableCounter,ArrayList<Variable> variableList) {
		this.name = name;
		this.description = description;
		this.waitTime = waitTime;
		this.invalidValue = invalidValue;
		this.variableCounter = variableCounter;
		this.variableList = variableList;
	}
	
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
