package collection;

import java.util.WeakHashMap;

class User {
	public int id;

	public User(int id) {
		this.id = id;
	}

}

public class TestWeakRef {
	public static void main(String[] args) throws InterruptedException {

		final int MAX = 10000000;
		WeakHashMap<Integer, User> map = new WeakHashMap<>();
		int count = 0;
		while (true) {
			map.put(count++, new User(count));
			if (count > MAX) {
				System.out.println("count over " + MAX);
				System.out.println("map.size:" + map.size());
				System.out.println("User0.id:" + map.get(0).id);
				break;
			}
			Thread.sleep(1);
		}
	}
}
