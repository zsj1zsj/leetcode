package leetcode;

public class PermutationSequence {
	static public String getPermutation(int n, int k) {
		if (k > factorial(n))
			return null;

		for (int i = 1; i <= 9; i++) {
			System.out.println(factorial(i));
		}
		return "";
	}

	static int factorial(int n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		getPermutation(5, 100);
	}
}
