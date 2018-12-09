package leetcode;

import java.util.Stack;

public class LargestRectangleArea {
	static int largestRectangleArea(int[] height) {
		int maxarea = 0;
		Stack<Integer> sta = new Stack<>();
		int top;
		int top_area;
		int i = 0;
		while (i < height.length) {
			if (sta.isEmpty() || height[sta.peek()] <= height[i]) {
				sta.push(i++);
			} else {
				top = sta.pop();
				top_area = height[top] * (sta.isEmpty() ? i : i - sta.peek() - 1);
				if (top_area > maxarea) {
					maxarea = top_area;
				}
			}
		}
		while (!sta.isEmpty()) {
			top = sta.pop();
			top_area = height[top] * (sta.isEmpty() ? i : i - sta.peek() - 1);
			if (top_area > maxarea) {
				maxarea = top_area;
			}
		}
		return maxarea;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 6, 3, 2, 5, 4 };
		largestRectangleArea(arr);
	}

}
