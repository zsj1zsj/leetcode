package designpattern.visitor;

public interface Item {
	default public void accept(Visitor visitor){
		visitor.visit(this);
	}
}
