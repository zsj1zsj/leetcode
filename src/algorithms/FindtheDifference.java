package algorithms;

public class FindtheDifference {
	static public char findTheDifference(String s, String t) {
		
		int xor = t.charAt(0);
		
		for(int i = 1;i<t.length();i++){
			xor^=t.charAt(i);
		}
		
		for(int i=0;i<s.length();i++){
			xor^=s.charAt(i);
		}
		
		return (char)xor;
	}
	
	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		
		System.out.println(findTheDifference(s, t));
	}
}
