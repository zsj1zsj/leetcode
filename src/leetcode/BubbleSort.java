package leetcode;

public class BubbleSort {

	static void sort(int[] arr, int start, int end) {

		for (int i = 0; i < end; i++)
			for (int j = 0; j < end - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
	}

	public static void main(String[] args) {

		int[] arr = { 6, 8, 7, 4, 5, 3, 1, 2 };

		sort(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.format("%d, ", i);
		}
	}
}
