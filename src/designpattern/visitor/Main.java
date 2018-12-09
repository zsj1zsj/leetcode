package designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		Apple a = new Apple();
		Orange o = new Orange();
		
		PriceVisitor priceVisotor = new PriceVisitor();
		
		
		List<Item> items = new ArrayList<Item>();
		items.add(a);
		items.add(o);
		
		
		for(Item item:items)
			item.accept(priceVisotor);
		
		
		
	}
}
