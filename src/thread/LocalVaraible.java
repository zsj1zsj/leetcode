package thread;

public class LocalVaraible {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				this.count();
			}

			public void count() {
				int counter = 0;
				for (int i = 0; i < 10000; i++) {
					counter = i;
				}

				System.out.println(Thread.currentThread().getName() + ": " + counter);
			}

		};

		Thread[] threads = new Thread[2];

		for (int i = 0; i < 2; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}
	}

}
