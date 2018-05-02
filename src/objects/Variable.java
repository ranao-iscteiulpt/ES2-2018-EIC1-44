package objects;

public class Variable {
	
	private String name;
	private String type;
	private int minValue;
	private int maxValue;
	
	public Variable(String name, String type, int minValue, int maxValue) {
		this.name = name;
		this.type = type;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

}
