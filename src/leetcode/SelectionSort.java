package leetcode;

public class SelectionSort {
	static void sort(int[] arr, int start, int end) {

		for (int i = 0; i < end; i++) {
			int min = arr[i];
			int minInx = i;
			for (int j = i; j < end; j++) {
				if (min > arr[j]){
					min = arr[j];
					minInx =j;
				}
			}
			// swap
			int tmp = arr[i];
			arr[i] = arr[minInx];
			arr[minInx] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 6, 8, 7, 4, 5, 3, 1, 2 };

		sort(arr, 0, arr.length);

		for (int i : arr) {
			System.out.format("%d, ", i);
		}
	}
}
