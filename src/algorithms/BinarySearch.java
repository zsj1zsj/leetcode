package algorithms;

import java.util.Random;

public class BinarySearch {
	static int a[];
	static int N = 1000;
	static {
		Random rand = new Random();
		a = new int[N];
		int prev = 1;
		a[0] = 1;

		for (int i = 1; i < N; i++) {
			a[i] = prev + Math.abs(rand.nextInt() % 3) + 1;
			prev = a[i];
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < N; i++)
			System.out.print(a[i] + ", ");

		System.out.println();
		System.out.println("search value: " + a[23]);
		// int result = searchWithRecursion(99995, 0, N - 1);
		int result = search(a[23]);
		System.out.format("a[%d]:%d\n",result, a[result]);
	}

	static int counter = 0;

	static int searchWithRecursion(int key, int lo, int hi) {
		if (hi < lo)// hi和lo是在变化的
			return lo;
		int mid = lo + (hi - lo) / 2;

		System.out.println("Counter:" + ++counter);

		if (key < a[mid])
			return searchWithRecursion(key, lo, mid - 1);
		else if (key > a[mid])
			return searchWithRecursion(key, mid + 1, hi);
		return mid;
	}

	static int search(int key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}
}
