package designpattern.state;

public class StateManagement {
	Light state;

	public StateManagement() {
		state = Light.red;
	}

	public Light getCurrentState() {
		return state;
	}

	public void next() {
		state = state.next();
	}
}
