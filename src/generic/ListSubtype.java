package generic;

import java.util.ArrayList;
import java.util.List;

public class ListSubtype {
	public static void main(String[] args) {
		Apple apple = new Apple();
		apple.setName("apple");
		Orange orange = new Orange();
		orange.setName("orange");

		List<Apple> apples = new ArrayList<Apple>();
		List<? extends Fruit> fruits = apples;

//		fruits.add(new Apple());

		fruits.stream().map(f -> f.getName()).forEach(System.out::println);

	}
}
