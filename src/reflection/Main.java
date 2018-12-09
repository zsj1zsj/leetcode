package reflection;

import PO.Employee;

public class Main {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class clazz = Class.forName("PO.Employee");
		Object unkonwnObj = clazz.newInstance();
		Employee emp = null;
		
		if (unkonwnObj instanceof Employee) {
			System.out.println("is employee object.");
			emp = (Employee) unkonwnObj;
		} else {
			System.out.println("not employee object.");
		}
		
		System.out.println(emp);
	}
}
