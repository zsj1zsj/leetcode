package algorithms;

public class DecodeWays {
	static private int dfs(String s, int pos) {
		if (pos < s.length() && s.charAt(pos) == '0')
			return 0;
		if (pos == s.length())
			return 1;
		int nWay = dfs(s, pos + 1);//第一个字符作为一个码的情况
		int val = 0;
		if (pos + 1 < s.length())//
			val = Integer.parseInt(s.substring(pos, pos + 2));
		if (val >= 10 && val <= 26)
			nWay += dfs(s, pos + 2);
		return nWay;
	}

	static private int dp(String s) {
		int n = s.length();
		int[] fn = new int[n + 1];
		fn[0] = 1;
		fn[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) != '0')
				fn[i + 1] = fn[i];
			int v = Integer.parseInt(s.substring(i - 1, i + 1));
			if (v >= 10 && v <= 26)
				fn[i + 1] += fn[i - 1];
		}
		return fn[n];
	}

	public static void main(String[] args) {

		String s = "130";

		// System.out.println(dfs(s, 0));
		System.out.println(dp(s));
	}

}
