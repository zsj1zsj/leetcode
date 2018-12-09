package algorithms;

public class AmstrongNumber {

	public static void main(String[] args) {
		System.out.println(isAmstrongNumber(1634));
	}

	static boolean isAmstrongNumber(int num) {
		int digit = 0;
		int sum = 0;
		int temp = num;
		int len = (int) Math.ceil(Math.log10(num));
		while (temp != 0) {
			digit = temp % 10;
			temp /= 10;
			sum += Math.pow(digit, len);
		}

		if (sum == num)
			return true;

		System.out.println("sum=" + sum);
		return false;
	}
}
