package objects;

public class Variable {
	
	private String name;
	private String type;
	private int minValue;
	private int maxValue;
	private double minValueDouble;
	private double maxValueDouble;
	
	/**
	 * Method to create a new variable
	 * @param name variable name
	 * @param type variable type (double, integer or binary)
	 * @param minValueDouble minimum variable value
	 * @param maxValueDouble maximum variable value
	 */
	
	public Variable(String name, String type, double minValueDouble, double maxValueDouble) {
		this.name = name;
		this.type = type;
		this.minValueDouble = minValueDouble;
		this.maxValueDouble = maxValueDouble;		
	}
	
	/**
	 * Method to create a new variable
	 * @param name variable name
	 * @param type variable type (double, integer or binary)
	 * @param minValue minimum variable value
	 * @param maxValue maximum variable value
	 */
	
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
	
	public double getMinValueDouble() {
		return minValueDouble;
	}
	
	public double getMaxValueDouble() {
		return maxValueDouble;
	}
	
	@Override
	public String toString() {
		return "Variable [name=" + name + ", type=" + type + ", minValue=" + minValue + ", maxValue=" + maxValue + "]";
	}
		

}
