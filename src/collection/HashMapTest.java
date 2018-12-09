package collection;

import java.util.HashMap;

import PO.Employee;

public class HashMapTest {
	public static void main(String[] args) {

		HashMap m = new HashMap<Employee, String>();

		Employee e1 = new Employee(1, "jason");
		m.put(e1, "jason");
		
		Employee e2 = new Employee(1,"jason");
		System.out.println(m.get(e2));
		
		System.out.println("e1.hashcode:"+e1.hashCode());
		System.out.println("e2.hashcode:"+e2.hashCode());
		System.out.println("tom.hashcode:"+new Employee(2,"tom").hashCode());
		System.out.println("empty.hashcode:"+new Employee().hashCode());
	}
}
