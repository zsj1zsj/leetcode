package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest implements Runnable {
	private volatile int count = 0;
	private AtomicInteger countI = new AtomicInteger(0);
	private ThreadLocal<Integer> countTL = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 0;
		};
	};

	private void increment() {
		count++;
		countI.incrementAndGet();
		int temp = countTL.get();
		temp++;
		countTL.set(temp);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			increment();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + ": " + count);
		System.out.println(Thread.currentThread().getName() + ".atomic: " + countI.get());
		System.out.println(Thread.currentThread().getName() + ".threadlocal: " + countTL.get());

	}

	public static void main(String[] args) {
		int num = 10;
		long start = System.currentTimeMillis();
		Runnable r = new VolatileTest();
		Thread[] t = new Thread[num];
		// why result not correct
		for (int i = 0; i < num; i++) {
			t[i] = new Thread(r);
			t[i].start();
		}

		try {
			for (int i = 0; i < num; i++) {
				t[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println((System.currentTimeMillis() - start) + "s");
	}

}
