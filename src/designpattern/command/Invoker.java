package designpattern.command;

import java.util.Stack;

public class Invoker {
	Stack<Command> commandStack = new Stack();

	void doit(Command comm) {
		comm.execute();
		commandStack.add(comm);
	}

	void undo() {
		if (commandStack.size() <= 0) {
			System.out.println("cannot undo.");
			return;
		}
		Command comm = commandStack.pop();
		comm.undo();
	}
}
