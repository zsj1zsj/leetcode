package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
	static public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int len = nums1.length + nums2.length;
	
		boolean odd = false;
		// even or odd
		if (len % 2 == 1)
			odd = true;
		else
			odd = false;
		
		if(nums1.length==0){
			if(odd){
				return nums2[nums2.length/2];
			}
			else{
				return (nums2[nums2.length/2-1]+nums2[nums2.length/2-1])/2.0;
			}
		}else if(nums2.length==0){
			if(odd){
				return nums1[nums1.length/2];
			}
			else{
				return (nums1[nums1.length/2-1]+nums1[nums1.length/2-1])/2.0;
			}
		}

		int index1 = 0;
		int index2 = 0;
		

		for (int i = 0, j = 0; i + j + 2 < len / 2;) {
			if (nums1[i] >= nums2[j]) {
				index2 = ++j;
			} else {
				index1 = ++i;
			}
		}

		System.out.format("i:%d, j:%d\n", index1, index2);

		double result = 0.0;
		double lmid = 0.0;
		double rmid = 0.0;
		if (odd) {
			lmid = nums1[index1] >= nums2[index2] ? nums1[index1] : nums2[index2];
			result = lmid;
		} else {
			lmid = nums1[index1] >= nums2[index2] ? nums1[index1] : nums2[index2];
			rmid = nums1[index1 + 1] >= nums2[index2 + 1] ? nums2[index2 + 1] : nums1[index1 + 1];
			result =  (lmid+rmid)/2;
		}

		return result;
	}

	public static void main(String[] args) {
		// int[] nums1 = { 3, 5, 8, 9 };
		// int[] nums2 = { 1, 2, 7, 10, 11, 12 };
		// int[] nums1 = {1,2};
		// int[] nums2 = {3,4};
		int[] nums1 = {1};
		int[] nums2 = { 1 };

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			list.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			list.add(nums2[i]);
		}

		Collections.sort(list);

		for (Integer i : list) {
			System.out.println(i);
		}

		double result = findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}
}
