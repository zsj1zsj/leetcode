package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {

		Map<Character, Integer> map = new HashMap<>();

		if (magazine.length() == 0)
			return false;

		for (int i = 0; i < magazine.length(); i++) {
			char c = magazine.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			if (map.containsKey(c) && map.get(c) > 0) {
				int val = map.get(c);
				map.put(c, val - 1);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
