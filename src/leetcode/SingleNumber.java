package leetcode;

public class SingleNumber {
	static public int singleNumber(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}

	public static void main(String[] args) {

		int[] nums={2,2,1};
		System.out.println(singleNumber(nums));
	}
}
