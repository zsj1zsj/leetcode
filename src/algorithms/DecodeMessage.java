package algorithms;

import java.util.Stack;

public class DecodeMessage {

	static Stack<Integer> decode(String str, int index, int dn, Stack<Integer> dl) {

		Stack<Integer> delimiter = new Stack<>();

		if (index + dn >= str.length())
			return delimiter;
		else {

		}
		
		return null;

	}

	public static void main(String[] args) {
		String str = "1234";
		Stack<Integer> dl = new Stack<>();
		decode(str, 0, 0, dl);
	}
}
