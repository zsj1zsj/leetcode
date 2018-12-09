package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		// System.getProperties().entrySet().stream().map(e -> e.getKey() + ": "
		// + e.getValue())
		// .forEach(System.out::println);

		Properties props = System.getProperties();
		// props.propertyNames();
		Set<String> set = props.stringPropertyNames();

		// for(String key:set){
		// String value = System.getProperty(key);
		// System.out.println(key+":"+value);
		// }

		// System.out.println(System.getProperty("test"));
		// System.out.println(System.getProperty("test2"));

		String str = String.format("%0" + 10 + "d", 0);
		str = String.join("", Collections.nCopies(11, "s"));
		System.out.println(str);

		// int[] i = new int[1];
		// System.out.println(i[0]);

		// System.out.println(new String(new char[10]).replace('\0', 'a'));
		//
		// Process p = Runtime.getRuntime().exec("cmd /c pause");

		// Runtime.getRuntime().addShutdownHook(new Thread() {
		// @Override
		// public void run() {
		// System.out.println("shutdown");
		// File f = new File("test.ttt");
		// try {
		// f.createTempFile("test", "ttt");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// });

		// List<String> list = new ArrayList<String>();
		// list.add("first item");
		// list.add("second item");
		// list.add("third item");
		// for(String s:list)
		// System.out.println(s);
		// String[] strs =(String[])list.toArray(new String[0]);
		// for(int i=0;i<strs.length;i++)
		// System.out.println(strs[i]);

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class clazz = classLoader.loadClass("test.StaticAndConstructorTest");
		// Class clazz = Class.forName("test.StaticAndConstructorTest");
		// clazz.newInstance();
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());

		System.out.println(i);

		ArrayList<String> list = new ArrayList<String>();
		int N = 100000;
		for (int i = 0; i < N; i++)
			list.add("i" + i);

		cost(() -> list.remove("i99999"));
		cost(() -> list.remove("i99998"));
		cost(() -> list.remove("i99997"));
		cost(() -> list.remove("i99996"));
		cost(() -> list.remove("i0"));
		cost(() -> list.remove("i1"));
		cost(() -> list.remove("i2"));
		cost(() -> list.remove("i3"));


	}

	static void cost(Runnable r) {
		long before = System.nanoTime();
		r.run();
		System.out.println((System.nanoTime() - before));
	}

	static int i;
}
