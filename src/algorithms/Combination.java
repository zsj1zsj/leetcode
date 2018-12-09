package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
	static void combine(String str) {

		int length = str.length();
		StringBuffer output = new StringBuffer(length);

		combination(str, length, output, 0);
	}

	static void com1(String s) {
		comb1("", s);
	}

	static void comb1(String prefix, String s) {
		if (s.length() > 0) {
			System.out.println(prefix + s.charAt(0));
			comb1(prefix + s.charAt(0), s.substring(1));// 包含当前字符
			comb1(prefix, s.substring(1));// 不包含当前字符
		}
	}

	// alternate implementation
	public static void comb2(String s) {
		comb2("", s);
	}

	private static void comb2(String prefix, String s) {
		System.out.println(prefix);
		for (int i = 0; i < s.length(); i++)
			comb2(prefix + s.charAt(i), s.substring(i + 1));
	}

	static public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<>(), nums, 0);
		return result;
	}

	static private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList)); // new ArrayList<>(tempList):
												// 在不修改tempList引用的前提下添加tempList
		for (int i = start; i < nums.length; i++) {
			// if (i > start && nums[i] == nums[i - 1])continue; // skip
			// duplicates
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);// 回退上一层前，去除之前添加的字符
		}
	}

	static void combination(String str, int length, StringBuffer output, int allowedStart) {
		if (length == allowedStart)
			return;
		else {
			for (int curr = allowedStart; curr < length; curr++) {
				output.append(str.charAt(curr));
				System.out.println(output);
				combination(str, length, output, curr + 1);
				output.deleteCharAt(output.length() - 1);
			}
		}
	}

	static public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		dfs(list, n, new ArrayList<>(), k, 0);
		return list;
	}

	static void dfs(List<List<Integer>> list, int n, List<Integer> temp, int k, int start) {
		if (temp.size() == k) {
			list.add(new ArrayList<>(temp));
		} else if(temp.size()>k) {
			return;
		}

		for (int i = start + 1; i <= n; i++) {
			temp.add(i);
			dfs(list, n, temp, k, i);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		String str = "1234";
		int[] nums = { 1, 2, 3 };
		System.out.println(combine(4, 2));
	}
}
