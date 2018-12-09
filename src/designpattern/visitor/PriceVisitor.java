package designpattern.visitor;

public class PriceVisitor implements Visitor {
	@Override
	public void visit(Item item) {
		System.out.println("enter into visit item method");
		if (item instanceof Apple){
			System.out.println("is a apple item");
			this.visit((Apple)item);
		}
		if (item instanceof Orange){
			System.out.println("is a orange item");
			this.visit(item);
		}
			
	}

	public void visit(Apple apple) {
		System.out.println("the price of apple");
	}

	public void visit(Orange apple) {
		System.out.println("the price of orange");
	}

}
