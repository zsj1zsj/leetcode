package designpattern.command;

public class Command1 implements Command {

	private String text;

	public Command1(String str) {
		text = str;
	}

	@Override
	public void execute() {
		System.out.println(text + " executed");
	}

	@Override
	public void undo() {
		System.out.println(text + " undo");
	}
}
