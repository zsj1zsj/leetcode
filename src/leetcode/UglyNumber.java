package leetcode;

public class UglyNumber {
	public boolean isUgly1(int num) {

		if (num == 1)
			return true;

		if (num == 0)
			return false;

		// 2
		while (num % 2 == 0)
			num /= 2;

		// 3
		while (num % 3 == 0)
			num /= 3;

		// 5
		while (num % 5 == 0)
			num /= 5;

		if (num == 1)
			return true;

		return false;
	}

	public int nthUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;

		int i2 = 0, i3 = 0, i5 = 0;
		int next_multiple_of_2 = 2;
		int next_multiple_of_3 = 3;
		int next_multiple_of_5 = 5;
		int next_ugly_no = 1;

		for (int i = 1; i < n; i++) {
			next_ugly_no = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));

			ugly[i] = next_ugly_no;
			if (next_ugly_no == next_multiple_of_2) {
				i2 = i2 + 1;
				next_multiple_of_2 = ugly[i2] * 2;
			}
			if (next_ugly_no == next_multiple_of_3) {
				i3 = i3 + 1;
				next_multiple_of_3 = ugly[i3] * 3;
			}
			if (next_ugly_no == next_multiple_of_5) {
				i5 = i5 + 1;
				next_multiple_of_5 = ugly[i5] * 5;
			}

		}

		return next_ugly_no;
	}

	public static void main(String[] args) {
		System.out.println(new UglyNumber().nthUglyNumber(21));

	}
}
