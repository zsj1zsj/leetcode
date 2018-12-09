package algorithms;

public class TowerOfHanoi {
	public static void moves(int n, boolean left) {
		if (n == 0)
			return;
		moves(n - 1, !left);
		if (left)
			System.out.println(n + " left");
		else
			System.out.println(n + " right");
		moves(n - 1, !left);
	}

	static void moves(int n, int from, int to, int helper) {
		if (n == 1) {
			System.out.println("move a plate from " + from + " to " + to);
			return;
		}
		moves(n - 1, from, helper, to);// 把n-1个从from挪到helper上，借助to
		// move(from,to);//把第n个盘子直接从from挪到to
		System.out.println("move from " + from + " to " + to);
		moves(n - 1, helper, to, from);// 把n-1个从helper挪到from上，借助to
	}

	public static void main(String[] args) {
		int n = 3;
		// moves(n, true);
		moves(n, 1, 3, 2);
	}
}
