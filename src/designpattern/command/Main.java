package designpattern.command;

public class Main {
	public static void main(String[] args) {
		Command command1 = new Command1("first command");
		Command command2 = new Command1("second command");

		Invoker invoker = new Invoker();
		invoker.doit(command1);
		invoker.undo();
		invoker.doit(command2);
		invoker.undo();
	}
}
