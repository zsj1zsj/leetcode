package guava;

import com.google.common.base.Preconditions;

public class Main {
	Person person;

	public Main(Person p) {
		person = Preconditions.checkNotNull(p);
		// person = p;
		this.person.name = p.name;
		this.person.age = p.age;

	}

	public void showName() {
		System.out.println("Name: " + person.name);
		System.out.println("Age: " + person.age);
	}

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("test");
		p.setAge("20");
		new Main(p).showName();
//		Person p2 = null;
//		new Main(p2).showName();

		ClassLoader cl = Main.class.getClassLoader();
		System.out.println(cl.toString());
		System.out.println(cl.getParent().toString());
	}

}

class Person {
	String name;
	String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}