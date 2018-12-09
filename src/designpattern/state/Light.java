package designpattern.state;

public interface Light {
	static final Light red = new RedLight();
	static final Light yellow = new YellowLight();
	static final Light green = new GreenLight();
	
	public Light next();
	public void display();
}
