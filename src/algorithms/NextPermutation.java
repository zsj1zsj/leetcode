package algorithms;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;

		//从右向左扫描，找到第一个比右小的数。
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}

		if (i >= 0) {
			int j = nums.length - 1;
			//j从右向左扫描，找比nums[i]大的数
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
