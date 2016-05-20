package taller;

public class OpenParenthesis implements Operator {
	String string = "(";
	int precedence = 2;
	
	@Override
	public double apply(double a, double b) {
		return a + b;
	}

	@Override
	public int precedence() {
		return this.precedence;
	}
}
