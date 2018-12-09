package leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int c = 1;
		int[] res = new int[len + 1];

		res[0] = 0;
		for (int i = 1; i <= len; i++) {
			res[i] = digits[i - 1];
		}

		int index = len;
		while (c > 0) {
			int temp = res[index];
			res[index] = (res[index] + 1) % 10;
			c = (temp + 1) / 10;
			index--;
		}

		if (res[0] == 0) {
			int[] res2 = new int[len];
			for (int i = 0; i < len; i++) {
				res2[i] = res[i + 1];
			}
			return res2;
		}

		return res;
	}

	public static void main(String[] args) {

		PlusOne po = new PlusOne();
		int[] nums = { 9 };
		for (int i : po.plusOne(nums)) {
			System.out.println(i);
		}
	}
}
