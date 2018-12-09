package designpattern.state;

public class GreenLight implements Light {

	@Override
	public Light next() {
		return yellow;
	}

	public void display() {
		System.out.println("Green Light");
	}

}
