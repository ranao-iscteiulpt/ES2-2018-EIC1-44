package objects;

import java.util.ArrayList;

public class Problem {

	private ArrayList<Variable> variableList;
	private String name;
	private String description;
	private int waitTime;
	private int invalidValue;
	private int variableCounter;

	public Problem(String name, String description, int waitTime, int invalidValue, int variableCounter,ArrayList variableList) {
		this.name = name;
		this.description = description;
		this.waitTime = waitTime;
		this.invalidValue = invalidValue;
		this.variableCounter = variableCounter;
		this.variableList = variableList;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public int getInvalidValue() {
		return invalidValue;
	}

	public int getVariableCounter() {
		return variableCounter;
	}


}
