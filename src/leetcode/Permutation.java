package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	static long count = 0;

	private void permute2(String str, int l, int r) {
		if (l == r) {
			count++;
			// System.out.println(str);
		}

		else {
			permute(str, l + 1, r);
			for (int i = l + 1; i <= r; i++) {
				String copy = str;
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = copy;
			}
		}
	}

	private void permute(String str, int l, int r) {
		if (l == r) {
			count++;
			System.out.println(str);
		}

		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	static public void iterationPerm(String a) {
		List<String> prev = new ArrayList<>();
		List<String> curr = new ArrayList<>();

		for (char c : a.toCharArray()) {
			prev.add("" + c);
		}

		int len = 1;
		while (len < a.length() - 1) {
			curr = new ArrayList<>();
			for (char c : a.toCharArray()) {
				for (String str : prev) {
					if (str.indexOf(c) == -1) {
						curr.add(c + str);
					}
				}
			}
			len = curr.get(0).length();
			prev = curr;
		}

		System.out.println(curr.size());
		for (String s : curr) {
			System.out.println(s);
		}

	}

	public static void main(String[] args) {

		String str = "123";
		int n = str.length();
		Permutation permutation = new Permutation();

		long before = System.nanoTime();
		permutation.permute(str, 0, n - 1);
		System.out.println((System.nanoTime() - before) / 1000_000 + " ms");
		//
		before = System.nanoTime();
		// permutation.permute2(str, 0, n - 1);
		// System.out.println((System.nanoTime() - before) / 1000_000 + " ms");

		// iterationPerm(str);
		// System.out.println((System.nanoTime() - before) / 1000_000 + " ms");
	}
}
