package algorithms;

public class ReverseVowelsofaString {
	public String reverseVowels(String s) {
		int l = 0, r = s.length() - 1;

		if (s.trim().equals(""))
			return s;

		char[] str = s.toCharArray();

		while (l < r) {
			if (!isVowel(str[l]))
				l++;
			if (!isVowel(str[r]))
				r--;

			if (isVowel(str[l]) && isVowel(str[r])) {
				char temp = str[l];
				str[l++] = str[r];
				str[r--] = temp;
			}
		}
		return new String(str);
	}

	static boolean isVowel(char c) {
		switch (c) {
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			return true;
		default:
			return false;
		}
	}

	public static void main(String[] args) {

		System.out.println(reverseVowels("."));
	}
}
