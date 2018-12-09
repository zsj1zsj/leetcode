package designpattern.state;

public class YellowLight implements Light {

	@Override
	public Light next() {
		return green;
	}

	public void display() {
		System.out.println("Yellow Light");
	}

}
