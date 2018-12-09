package saicinterview;

abstract class Employee2 {
	protected abstract double getSalesAmount();

	public double getCommision() {
		return getSalesAmount() * 0.15;
	}
}

class Sales extends Employee2 {
	protected double getSalesAmount() {
		return 1230.45;
	}
}