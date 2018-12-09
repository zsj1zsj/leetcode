package algorithms;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;

		int l = 0, r = nums.length-1;
		while (l < r) {
			if (nums[l] <= nums[r]) {
				l++;
			} else {
				r--;
			}
			int sum = 0;
			for (int i = l; i <= r; i++) {
				sum += nums[i];
			}
			if (sum > max)
				max = sum;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray m = new MaximumSubarray();
		System.out.println(m.maxSubArray(nums));
	}
}
