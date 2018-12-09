package test;

public class B extends A {

	public String show(A a) {
		return "B and A";
	}

	public String show(B a) {
		return "B and B";
	}

	public static void main(String[] args) {
		A a = new B();
		B b = new B();
		
		System.out.println(a.show(b));
	}
}
