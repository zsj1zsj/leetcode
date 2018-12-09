package algorithms;

public class ReverseInteger {
	static public int reverse(int x) {

		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x = x / 10;
		}

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;

		return (int) result;
	}

	public static void main(String[] args) {

		System.out.println(reverse(1534236469));
		System.out.println(Math.pow(2, 31));
		System.out.println();
	}
}
