package jvm;

public class Test {
	static {
		System.out.println("Test class static block");
	}

	public int inc() {
		int x;
		try {
			x = 1;
			return x;
		} catch (Exception e) {
			x = 2;
			return x;
		} finally {
			x = 3;
		}

	}

	public static void main(String[] args) {
		Test test = new Test();
		test.inc();
	}
}
