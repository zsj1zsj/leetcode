package LIS;

public class Solution1 {
	 public int lengthOfLIS(int[] nums) {
	        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
	    }

	    public int lengthofLIS(int[] nums, int prev, int curpos) {
	        if (curpos == nums.length) {
	            return 0;
	        }
	        int taken = 0;
	        if (nums[curpos] > prev) {
	            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
	        }
	        int nottaken = lengthofLIS(nums, prev, curpos + 1);
	        return Math.max(taken, nottaken);
	    }
	    
	    public static void main(String[] args) {
			Solution1 s = new Solution1();
			int[] nums = {1,5,3,9,4,6};
			s.lengthOfLIS(nums);
		}
}
