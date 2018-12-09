package algorithms;

public class ContainerWithMostWater {
	static public int maxArea(int[] height) {

		int left = 0, right = height.length - 1;

		int maxArea = 0;

		while (left <= right) {
			int curArea = (right - left) * Math.min(height[left], height[right]);
			if (curArea > maxArea)
				maxArea = curArea;

			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));

	}
}
