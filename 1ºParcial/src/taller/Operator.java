package taller;

public interface Operator {
	double apply(double a, double b);
	int precedence();
}
