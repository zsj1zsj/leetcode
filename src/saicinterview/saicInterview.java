package saicinterview;

public class saicInterview {
	public static void main(String[] args) {
		System.out.println(new TestA() {
			public String toString() {
				return "test";
			}
		});
	}
}
