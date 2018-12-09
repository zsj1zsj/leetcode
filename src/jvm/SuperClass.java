package jvm;

public class SuperClass {

	static {
		System.out.println("Super class init");
		value = 32;
	}

	public static int value = 123;
}
