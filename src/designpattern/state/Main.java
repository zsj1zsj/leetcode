package designpattern.state;

public class Main {
	public static void main(String[] args) {

		StateManagement state = new StateManagement();

		state.getCurrentState().display();

		state.next();
		state.getCurrentState().display();
		
		state.next();
		state.getCurrentState().display();
	}
}
