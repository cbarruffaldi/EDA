package taller;

public class Sum implements Operator {

	char string = '+';
	int precedence = 0;
	
	@Override
	public double apply(double a, double b) {
		return a + b;
	}

	@Override
	public int precedence() {
		return this.precedence;
	}

}
