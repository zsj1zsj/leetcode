package algorithms;

public class RangeSumQuery {
	int[] st;

	public RangeSumQuery(int[] nums) {
		int len = nums.length;
		int stLen = (int) Math.ceil(Math.log(len) / Math.log(2)) - 1;
		st = new int[stLen];
		constructST(nums, st);
	}

	void constructST(int[] nums, int[] st) {
		int len = nums.length;
		for (int i = 0; i < nums.length; i++) {
			st[len / 2 + i] = nums[i];
		}

	}

	public void update(int i, int val) {

	}

	public int sumRange(int i, int j) {
		return 0;

	}

	public static void main(String[] args) {

	}
}
