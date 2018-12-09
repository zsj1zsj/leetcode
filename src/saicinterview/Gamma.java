package saicinterview;

class Foo {
	private int x;

	public Foo(int x) {
		this.x = x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}
}

public class Gamma {
	static Foo fooBar(Foo foo) {
		foo = new Foo(100);
		return foo;
	}

	public static void main(String[] args) {
		Foo foo = new Foo(300);
		System.out.print(foo.getX() + "-");

		Foo fooFoo = fooBar(foo);
		System.out.print(foo.getX() + "-");
		System.out.print(fooFoo.getX() + "-");

		foo = fooBar(fooFoo);
		System.out.print(foo.getX() + "-");
		System.out.print(fooFoo.getX());

		Integer x = 199;
		Integer y = x;
		System.out.println();
		System.out.println(x==y);
		x++;
		System.out.println(x==y);
		System.out.println();
		System.out.println(x + ":" + y);
	}
}