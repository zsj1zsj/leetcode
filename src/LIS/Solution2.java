package LIS;

import java.util.Arrays;

public class Solution2 {
	public int lengthOfLIS(int[] nums) {
		int memo[][] = new int[nums.length + 1][nums.length];
		for (int[] l : memo) {
			Arrays.fill(l, -1);
		}
		return lengthofLIS(nums, -1, 0, memo);
	}

	public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
		if (curpos == nums.length) {
			return 0;
		}
		if (memo[previndex + 1][curpos] >= 0) {
			return memo[previndex + 1][curpos];
		}
		int taken = 0;
		if (previndex < 0 || nums[curpos] > nums[previndex]) {
			taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
		}

		int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
		memo[previndex + 1][curpos] = Math.max(taken, nottaken);
		return memo[previndex + 1][curpos];
	}

	public static void main(String[] args) {

		Solution2 l = new Solution2();
		int[] nums = { 4, 2, 3, 8, 5 };
		System.out.println(l.lengthOfLIS(nums));
	}
}
