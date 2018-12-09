package algorithms;

import java.util.Random;

public class TestRandom {
	public static void main(String[] args) {

		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.println(Math.abs(rand.nextInt() % 3 )+1);

		}
	}
}
