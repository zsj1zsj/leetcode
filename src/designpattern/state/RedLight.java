package designpattern.state;

public class RedLight implements Light {

	public Light next() {
		return yellow;
	}
	
	public void display(){
		System.out.println("Red Light");
	}
}
