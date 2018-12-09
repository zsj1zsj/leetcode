package saicinterview;

import java.net.StandardSocketOptions;


public class SimpleCalc {
	public int value;

	public void calculate() {
		value += 7;
	}
	
	
	public static void main(String[] args) {
		SimpleCalc calc = new SimpleCalc();
		calc.calculate();
		System.out.println(calc.value);
	}
}
