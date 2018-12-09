package leetcode;

public class JumpII {
	static int jump(int[] nums) {
		int ret = 0;
		int last = 0;//前一点所能达到的势力范围
		int curr = 0; // 当前能走的最大步数
		for (int i = 0; i < nums.length; ++i) {//
			if (i > last) {//如果超过势力范围，ret加一说明采用其中某一步
				last = curr;
				++ret;
			}
			curr = Math.max(curr, i + nums[i]);
		}

		return ret;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));
		int[] nums2 = { 1, 1, 3, 1, 1, 2, 9, 1, 4 };
		System.out.println(jump(nums2));
	}
}
