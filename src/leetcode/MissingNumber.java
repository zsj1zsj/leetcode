package leetcode;

public class MissingNumber {
	static public int missingNumber(int[] nums) {
		if (nums.length == 0)
			return 0;
		
		int sum = (1 + nums.length) * nums.length / 2;

		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 1};

		System.out.println(missingNumber(nums));
	}
}
