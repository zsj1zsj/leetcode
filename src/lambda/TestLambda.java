package lambda;

import java.util.stream.LongStream;

public class TestLambda {
	public static void main(String[] args) throws InterruptedException {
		measurelambdacost();
		measurelambdaparrelcost();
	}

	static void measurelambdaparrelcost() throws InterruptedException {
		long begin = System.nanoTime();
		LongStream.rangeClosed(1, 100000000).parallel().filter(i -> i % 2 == 0).count();
		System.out.println("   parrel:" + (System.nanoTime() - begin) + " nano secs");

	}

	static void measurelambdacost() throws InterruptedException {
		long begin = System.nanoTime();
		LongStream.rangeClosed(1, 100000000).filter(i -> i % 2 == 0).count();
		System.out.println("no parrel:" + (System.nanoTime() - begin) + " nano secs");
	}
}
