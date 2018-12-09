package test;

public class StaticAndConstructorTest {
	static {
		System.out.println("static block.");
	}
	
	public StaticAndConstructorTest() {
		System.out.println("Constructor block.");
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		
//		Class clazz = classLoader.loadClass("test.StaticAndConstructorTest");
//		clazz.newInstance();
	}
}
