package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> solutions = new ArrayList<>();
		restoreIP(s, solutions, 0, "", 0);
		return solutions;
	}

	public void restoreIP(String s, List<String> solutions, int index, String restored, int count) {
		if (count > 4)
			return;
		if (count == 4 && index == s.length())
			solutions.add(restored);

		for (int i = 1; i < 4; i++) {
			if (index + i > s.length())
				break;
			String temp = new String(s.substring(index, index + i));
			if ((temp.startsWith("0") && temp.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256))
				continue;
			restoreIP(s, solutions, index + i, restored+temp+(count==3?"" : "."), count + 1);
		}

	}
}
