package algorithms;

public class QuickSort {
	static void sort(int[] arr, int start, int end) {
		int pivot = arr[end];

		if (start == end)
			return;

		int i = start, j = end;
		while (i < j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;

			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// swap pivot
		int temp = arr[end];
		arr[end] = arr[i];
		arr[i] = temp;

		if (start < j)
			sort(arr, start, j);
		if (i < end)
			sort(arr, i, end);

		System.out.println();
		System.out.format("i:%d, j:%d\n", i, j);
	}
	
	static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }

	public static void main(String[] args) {

		int[] arr = { 2, 6, 5, 0, 8, 7, 1, 3 };
		
		

//		for (int i = 0; i < arr.length; i++)
//			System.out.format("%d, ", arr[i]);
//
//		sort(arr, 0, arr.length - 1);
		
		partition(arr, 0, arr.length-1);

		for (int i = 0; i < arr.length; i++)
			System.out.format("%d, ", arr[i]);

	}
}
