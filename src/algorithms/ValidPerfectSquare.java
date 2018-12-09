package algorithms;

public class ValidPerfectSquare {
	static public boolean isPerfectSquare(int num) {

		long low = 1;
		long high = num;

		long m = (1 + num) / 2;
		
		if(num==1)return true;

		while (low < high) {
			m = (low + high) / 2;
			if (m * m == num)
				return true;
			else if (m * m < num) {
				low = m + 1;
			} else {
				high = m;
			}
		}
		return false;
	}

	public static void main(String[] args) {

//		System.out.println(isPerfectSquare(100));
//		System.out.println(isPerfectSquare(10000));
		System.out.println(isPerfectSquare(2147483647));
	}
}
