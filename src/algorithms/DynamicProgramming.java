package algorithms;

import java.util.function.Function;

public class DynamicProgramming {
	static long[] numbers = new long[100];

	static void initializeArr() {
		for (int i = 0; i < 100; i++) {
			numbers[i] = -1;
		}
	}

	static long fib(int n) {
		if (numbers[n] == -1) {
			if (n == 0){
				numbers[0] = 0;
				return 0;
			}
			if (n == 1){
				numbers[1] = 1;
				return 1;
			}
			numbers[n] = fib(n - 1) + fib(n - 2);
		}
		return numbers[n];
	}

	static long fib_loop(int n) {
		for (int i = 0; i < n; i++) {
			if (i <= 1) {
				numbers[i] = 1;
			} else {
				numbers[i] = numbers[i - 1] + numbers[i - 2];
			}
		}
		return numbers[n - 1];
	}

	static void testTimeCost(int num, Function<Integer, Long> f) {
		long start = System.currentTimeMillis();
		initializeArr();

		System.out.println("--------value: " + num + " start ----------");
		System.out.println("function return value: " + f.apply(num));
		System.out.println("cost: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println("--------value: " + num + " end   ----------");
	}

	public static void main(String[] args) {
		final long N = 80;
		// for (int i = 3; i <= N; i++)
		// System.out.print(i + ":" + fib(i) + ", ");

		// System.out.println();

		for (int i = 3; i <= N; i++)
			testTimeCost(i, DynamicProgramming::fib);
		// testTimeCost(i, DynamicProgramming::fib_loop);
	}
}
