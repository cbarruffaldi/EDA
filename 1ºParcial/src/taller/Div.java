package taller;

public class Div implements Operator{
	char string = '/';
	int precedence = 1;
	
	@Override
	public double apply(double a, double b) {
		return a / b;
	}

	@Override
	public int precedence() {
		return this.precedence;
	}
}
