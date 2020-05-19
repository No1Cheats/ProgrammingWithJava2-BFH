package ObjectDesign;

public class Purse {
	public static final double NICKEL_VALUE = 0.05;
	public static final double DIME_VALUE = 0.1;
	public static final double QUARTER_VALUE = 0.25;

	private double totalValue = 0;
	
	public void addCoin(double coinValue)	{
		this.totalValue = this.totalValue + coinValue;
	}
}