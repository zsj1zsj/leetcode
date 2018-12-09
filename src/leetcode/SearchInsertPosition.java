package leetcode;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		return binarysearch(nums, 0, nums.length - 1, target);
	}

	int binarysearch(int[] nums, int low, int high, int val) {
		if (low < 0 || high < 0)
			return 0;
		if (low >= high)
			return (val > nums[high] ? high + 1 : high);
		int m = (low + high) / 2;
		if (val < nums[m]) {
			return binarysearch(nums, low, m - 1, val);
		} else if (val > nums[m]) {
			return binarysearch(nums, m + 1, high, val);
		} else {
			return m;
		}
	}

	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] nums = { 1, 3 };
		System.out.println(sip.searchInsert(nums,0 ));
	}
}
