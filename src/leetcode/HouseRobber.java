package leetcode;

public class HouseRobber {
	static int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return rob_dfs(nums, 0);
	}

	static int rob_dfs(int[] nums, int pos) {

		int take = nums[0], notake = nums[1];
		if (pos == nums.length - 1)
			return nums[nums.length - 1];
		if (pos > nums.length - 1)
			return 0;

		take = nums[pos] + rob_dfs(nums, pos + 2);
		notake = rob_dfs(nums, pos + 1);
		if (take > notake)
			return take;
		else
			return notake;
	}

	static int rob_dp(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		
		if(len==0)return 0;
		if(len==1)return nums[0];
		if(len==2)return Math.max(nums[0], nums[1]);

		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		
		
		for(int i=2;i<len;i++){
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		
		return dp[len-1];
	}

	public static void main(String[] args) {

		int[] nums = {1,2,3,1 };

		System.out.println(rob_dp(nums));

	}
}
