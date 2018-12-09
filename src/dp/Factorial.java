package dp;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(f(5));
		System.out.println(Fibonacci(8));
		System.out.println(combination(5));

		System.out.println(profit(3, 0, 3));

	}

	static int f(int n) {
		if (n == 1)
			return 1;
		return n * f(n - 1);
	}

	static int Fibonacci(int n) {
		// 1, 1, 2, 3, 5, 8, 13
		if (n <= 2)
			return 1;
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	static int combination(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		// 3=c(2)+c(0)+c(-1)
		// 4=c(3)+c(1)+c(0)
		return combination(n - 1) + combination(n - 3) + combination(n - 4);
	}

	static int[] p = { 2, 3, 5, 1 };

	static int profit(int year, int be, int en) {
		if (be > en)
			return 0;
		return Math.max(
				profit(year + 1, be + 1, en)+year*p[be], 
				profit(year + 1, be, en - 1)+year*p[en]
				);
	}
}
