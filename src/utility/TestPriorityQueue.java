package utility;

import java.net.Proxy;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class TestPriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<ProxyPriority> p = new PriorityQueue<ProxyPriority>(
				new Comparator<ProxyPriority>() {
					@Override
					public int compare(ProxyPriority o1, ProxyPriority o2) {
						return o1.priority > o2.priority ? -1 : o1.priority < o2.priority ? 1 : 0;
					}

				});
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			ProxyPriority cp = new ProxyPriority(null, System.currentTimeMillis());
			try {
				Thread.sleep(Math.abs(r.nextInt() % 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p.add(cp);
		}

		for (ProxyPriority connp : p) {
			System.out.println(connp.priority);
		}

		System.out.println("-----------------------");
		
		System.out.println(p.size());
		int len = p.size();
		for (int i = 0; i < len; i++) {
			System.out.print(i+":");
			System.out.println(p.poll().getPriority());
		}
	}
}

class ProxyPriority {
	Proxy proxy;
	long priority;


	public ProxyPriority(Proxy proxy, long priority) {
		super();
		this.proxy = proxy;
		this.priority = priority;
	}

	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
