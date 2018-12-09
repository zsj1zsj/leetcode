package lambda;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Double> futurePrice = new CompletableFuture<Double>();

		new Thread(() -> {
			double price = calculatePrice("product");
			futurePrice.complete(price);
		}).start();
		
		
		
		
		System.out.println("before futureprice.");
		System.out.println(futurePrice.get());
		System.out.println("main is done.");
	}

	static double calculatePrice(String product) {
		delay();
		Random rand = new Random();
		return rand.nextDouble() * 10 - 0.3;
	}

	static void delay() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
