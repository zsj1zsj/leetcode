package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {
	static public void rotate(int[] nums, int k) {

		int len = nums.length;

		List<Integer> list = new ArrayList<>();

		k %= len;

		if (k == 0||k==nums.length)
			return;


		for (int i = len - k; i < len; i++) {
			list.add(nums[i]);
		}

		for (int i = 0; i < len - k; i++) {
			list.add(nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = list.get(i);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);

	}
}
