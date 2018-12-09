package algorithms;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int[] dp = new int[nums.length];
		dp[nums.length - 1] = 0;

		for (int i = dp.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= nums[i]; j++) {
				if (i + j > nums.length)
					continue;
				if (dp[i + j] + 1 < min && dp[i + j] != -1)
					min = dp[i + j] + 1;
			}
			if (min == Integer.MAX_VALUE) {
				dp[i] = -1;
			} else {
				dp[i] = min;
			}
		}
		if (dp[0] != -1)
			return true;
		return false;
	}

	public static void main(String[] args) {

		JumpGame jg = new JumpGame();
		int[] nums = { 0, 2, 3 };
		System.out.println(jg.canJump(nums));
	}
}
