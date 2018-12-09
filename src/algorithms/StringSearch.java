package algorithms;

public class StringSearch {
	public static void main(String[] args) {

		String txt = "ABCABCCDABCCGAFDDAFFBABSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADASFJSOFJHOABCCEFIBZXVCYTV";
		String pat = "ABCCE";

		long start = System.nanoTime();
		txt.indexOf(pat);
		System.out.println((System.nanoTime() - start));

		start = System.nanoTime();
		char first = pat.charAt(0);
		for (int i = 0; i < txt.length() - pat.length() - 1; i++) {
			if (txt.charAt(i) == first) {
				// System.out.println("find it");
				if (txt.substring(i, i + pat.length()).equals(pat)) {
					break;
				}
			}
		}

		System.out.println((System.nanoTime() - start));
	}
}
