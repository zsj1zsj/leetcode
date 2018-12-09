package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	public static volatile int race = 0;
	// static AtomicInteger race = new AtomicInteger(0);

	public static void increase() {
		race++;
		// race.incrementAndGet();
	}

	private static final int THREADS_COUNT = 20;

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		Thread[] threads = new Thread[THREADS_COUNT];

		for (int i = 0; i < THREADS_COUNT; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 2000000; i++) {
						// synchronized (threads) {
						increase();
						// }
					}
				}
			}).start();
		}

		while (Thread.activeCount() > 1) {
			Thread.yield();
		}

		System.out.println(race);
		System.out.println((System.currentTimeMillis() - start) + "s");
	}

}
