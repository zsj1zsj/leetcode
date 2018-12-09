package thread;

public class Method {
	private int num = 10;

	// private Object lock = new Object();

	// 当前线程吃用当前对象的所
	public synchronized void method() {

		if (num > 8) {
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + " : " + num);
				num--;
			}
			try {
				System.out.println(Thread.currentThread().getName() + " wait begin ");
				// 调用父类Object的native方法wait()
				// super.wait();
				// this.wait();
				wait();
				System.out.println(Thread.currentThread().getName() + " wait end ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (num <= 7 && num > 1) {
			for (int i = 0; i < 7; i++) {
				System.out.println(Thread.currentThread().getName() + " : " + num);
				num--;
			}
			// 调用父类Object的native方法wait()
			// super.notify();
			// this.notify();
			notify();
			System.out.println(Thread.currentThread().getName() + " notify ");
		}
	}

	public static void main(String[] args) {
		final Method m = new Method();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				m.method();
			}
		}, "A");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				m.method();
			}
		}, "B");
		t1.start();
		t2.start();
	}
}
