package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {

	static final Integer[][] matrix = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
			{ 7, 8, 9, 1, 2, 3, 4, 5, 6 }, { 3, 1, 2, 6, 4, 5, 8, 9, 7 }, { 6, 4, 5, 9, 7, 8, 2, 3, 1 },
			{ 9, 7, 8, 3, 1, 2, 5, 6, 4 }, { 2, 3, 1, 5, 6, 4, 9, 7, 8 }, { 5, 6, 4, 8, 9, 7, 3, 1, 2 },
			{ 8, 9, 7, 2, 3, 1, 6, 4, 5 } };

	public static void main(String[] args) {
		System.out.println(checkRow(matrix));
		System.out.println(checkColumn(matrix));
		System.out.println(checkBox(matrix));
	}

	static boolean checkUnique(Integer[] arr) {
		List<Integer> la = Arrays.asList(arr);
		Set<Integer> set = new HashSet<Integer>();
		boolean flag = false;
		for (Integer ele : la) {
			set.add(ele);
		}

		int sum = 0;
		for (Integer ele : set) {
			sum += ele;
		}

		if (set.size() == 9 && sum == 45)
			flag = true;
		else
			flag = false;

//		System.out.print(flag + " : ");
		return flag;
	}

	static boolean checkRow(Integer[][] arr) {
		boolean rtnValue = true;
		for (int i = 0; i < 9; i++) {
			rtnValue &= checkUnique(arr[i]);
		}
		return rtnValue;
	}

	static boolean checkColumn(Integer[][] arr) {
		Integer[] tmpArr = new Integer[9];
		boolean rtnValue = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tmpArr[j] = matrix[j][i];
			}
			// for (Integer ele : tmpArr)
			// System.out.print(ele);
			// System.out.println();
			rtnValue &= checkUnique(tmpArr);
		}
		return rtnValue;
	}

	static boolean checkBox(Integer[][] arr) {
		boolean rtnValue = true;

		return rtnValue;
	}

	static boolean isSameMatric(Integer[][] a, Integer[][] b) {
		boolean rtnValue = true;

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (a[i][j].equals(b[i][j])) {
					rtnValue &= true;
				} else {
					rtnValue &= false;
				}
			}

		return rtnValue;
	}

}
