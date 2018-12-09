package algorithms;

public class PalindromeNumber {
	static public boolean isPalindrome(int x) {
		if (x < 0)
			return false;

		String val = String.valueOf(x);
		StringBuilder l = null;
		StringBuilder r = null;

		if (val.length() % 2 == 0) {
			l = new StringBuilder(val.substring(0, val.length() / 2 ));
		} else {
			l = new StringBuilder(val.substring(0, val.length() / 2+1));
		}
		r = new StringBuilder(val.substring(val.length() / 2, val.length()));

		return l.reverse().toString().equals(r.toString());
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(1221));

	}
}
