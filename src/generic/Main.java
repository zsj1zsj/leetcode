package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;

import designpattern.visitor.Apple;
import designpattern.visitor.Item;
import designpattern.visitor.Orange;

public class Main {
	public static void main(String[] args) {
		List<String> c = new ArrayList<String>();
		c.add("foo");
		c.add("bar");

		print(c);
		
		List<String> sl =new ArrayList<String>();
		List ol =(List) sl;
		Integer i =new Integer(2);
		ol.add(i);
		
		
		
//		List<String>[] stringLists = new ArrayList<String>[1];
		
		
		List<? extends Item> items = new ArrayList<Item>();
		Apple a = new Apple();
		Orange o = new Orange();
//		items.add(a);
//		items.add(o);
		
		List<String> strings = new ArrayList<>();
		
		


		
	}

	static void print(Collection<?> c) {
		Collection cn =(Collection) c;
		cn.add("test");
		for (Object o : cn)
			System.out.println(o);
	}
}
