package algorithms;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if (s.trim() == "" || s == null)
			return 0;

		String str = s.trim();

		String[] arr = str.split("\\s");

		return arr[arr.length - 1].length();
	}
	
	public static void main(String[] args) {
		LengthofLastWord lf = new LengthofLastWord();
		System.out.println(lf.lengthOfLastWord("Hello World"));
	}
}
