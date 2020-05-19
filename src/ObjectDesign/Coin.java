package ObjectDesign;
public class Coin {
	
	private static String name;
	private static double value;

	public Coin(String name, double value) { 
		this.name = name;
		this.value = value;
	}
	
	public double getValue() { 
		return this.value;
	}
}